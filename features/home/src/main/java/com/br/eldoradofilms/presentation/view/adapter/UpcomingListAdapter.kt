package com.br.eldoradofilms.presentation.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.br.eldoradofilms.R
import com.br.eldoradofilms.databinding.ItemUpcomingBinding
import com.br.eldoradofilms.presentation.model.MovieUI
import com.squareup.picasso.Picasso

internal class UpcomingListAdapter(
    private val clickCallback: (Int) -> Unit
) : ListAdapter<MovieUI, RecyclerView.ViewHolder>(MostPopularDiff) {

    private var movies: List<MovieUI> = emptyList()
    private lateinit var viewBinding: ItemUpcomingBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        viewBinding = ItemUpcomingBinding.inflate(inflater)

        return ItemsViewHolder(
            ItemUpcomingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            parent.context
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemsViewHolder -> {
                holder.update(movies[position])
            }
        }
    }

    fun update(movies: List<MovieUI>) {
        this.movies = emptyList()
        this.movies = movies
        submitList(this.movies)
    }

    inner class ItemsViewHolder(
        private val binding: ItemUpcomingBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun update(movie: MovieUI) {
            binding.filmImagePreview.setOnClickListener {
                clickCallback.invoke(movie.id)
            }

            val url = context.getString( R.string.base_url_images, movie.posterPath)
            Picasso.get()
                .load(url)
                .centerCrop()
                .fit()
                .placeholder(R.drawable.bg_home)
                .error(R.drawable.bg_home)
                .into(binding.filmImagePreview)
        }
    }

    override fun getItemCount(): Int = movies.size
}