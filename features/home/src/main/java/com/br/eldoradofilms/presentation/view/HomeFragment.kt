package com.br.eldoradofilms.presentation.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.HORIZONTAL
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.br.eldoradofilms.R
import com.br.eldoradofilms.databinding.FragmentHomeBinding
import com.br.eldoradofilms.presentation.listener.HomeListener
import com.br.eldoradofilms.presentation.model.MovieUI
import com.br.eldoradofilms.presentation.view.adapter.MostPopularListAdapter
import com.br.eldoradofilms.presentation.viewmodel.HomeViewAction
import com.br.eldoradofilms.presentation.viewmodel.HomeViewModel
import com.br.eldoradofilms.presentation.viewmodel.HomeViewState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()
    private var listener: HomeListener? = null
    private val mostPopularAdapter by lazy {
        MostPopularListAdapter { itemClicked ->
            onItemClicked(itemClicked)
        }
    }

    private val viewBinding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return viewBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is HomeListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement HomeListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupObservables()
        viewModel.onViewCreated()
    }

    private fun setupRecycler() {
        viewBinding.mostPopularList.layoutManager = CenterZoomLayoutManager(
            requireContext(), HORIZONTAL, false
        )
        viewBinding.mostPopularList.adapter = mostPopularAdapter
    }

    private fun setupObservables() {
        lifecycleScope.launch {
            viewModel.viewState.collect { state ->
                when (state) {
                    is HomeViewState.OnResume -> {
                        handleList(state.uiModel.list)
                        handleLoadingVisibility(state.uiModel.isLoading)
                    }
                    else -> {}
                }
            }
        }

        viewModel.viewAction.observe(viewLifecycleOwner) { action ->
            when(action) {
                HomeViewAction.ShowErrorScreen -> TODO()
            }
        }
    }

    private fun handleLoadingVisibility(isLoading: Boolean) {
        viewBinding.loadingMostPopular.isVisible = isLoading
    }

    private fun handleList(list: List<MovieUI>) {
        mostPopularAdapter.update(list)
    }

    private fun onItemClicked(movieClickedId: Int) {
        listener?.onMovieClicked(movieClickedId)
    }
}