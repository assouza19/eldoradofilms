package com.br.eldoradofilms.presentation.view

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.br.eldoradofilms.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.br.eldoradofilms.databinding.FragmentDetailsBinding
import com.br.eldoradofilms.presentation.model.DetailUi
import com.br.eldoradofilms.presentation.viewmodel.DetailsViewAction
import com.br.eldoradofilms.presentation.viewmodel.DetailsViewModel
import com.br.eldoradofilms.presentation.viewmodel.DetailsViewState
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val movieId by lazy {
        arguments?.getInt(MOVIE_ID) ?: 0
    }
    private val viewModel: DetailsViewModel by viewModel()
    private val viewBinding: FragmentDetailsBinding by lazy {
        FragmentDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtons()
        setupObservers()
        viewModel.onViewCreated(movieId)
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.viewState.collect { state ->
                when (state) {
                    is DetailsViewState.OnResume -> setupScreen(state.uiModel.result)
                    else -> {}
                }
            }
        }

        viewModel.viewAction.observe(viewLifecycleOwner) { action ->
            when(action) {
                DetailsViewAction.ShowErrorScreen -> {

                }
            }
        }
    }

    private fun setupScreen(result: DetailUi) {
        val url = requireActivity().getString( R.string.base_url_images, result.posterPath)

        Picasso.get()
            .load(url)
            .centerCrop()
            .fit()
            .placeholder(R.drawable.bg_home)
            .error(R.drawable.bg_home)
            .into(viewBinding.moviePoster)

        showBottomSheet()
    }

    private fun setupButtons() {
        viewBinding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun showBottomSheet() {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(viewBinding.bottomSheetContainer.id, MovieDetailsBottomSheet())
        transaction.commit()
    }

companion object {
        const val MOVIE_ID = "movieId"
    }
}