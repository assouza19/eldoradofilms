package com.br.eldoradofilms.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.br.eldoradofilms.R
import com.br.eldoradofilms.databinding.ActivityMainBinding
import com.br.eldoradofilms.presentation.listener.HomeListener
import com.br.eldoradofilms.presentation.view.DetailsFragment.Companion.MOVIE_ID
import com.br.eldoradofilms.utils.postDelay

private const val DELAY_SPLAASH = 2000L

class MainActivity : AppCompatActivity(), HomeListener {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupVisibility()
    }

    private fun setupVisibility() {
        postDelay(DELAY_SPLAASH) {
            binding.lottieAnimation.isVisible = false
            binding.navHostFragment.isVisible = true
            binding.bottomNavigation.isVisible = true
        }
    }

    override fun onMovieClicked(movieId: Int) {
        val bundle = Bundle()
        bundle.putInt(MOVIE_ID, movieId)
        navController.navigate(resId = R.id.navigate_to_details_fragment, bundle)
    }
}
