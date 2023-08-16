package com.br.eldoradofilms.presentation.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.br.eldoradofilms.presentation.model.MovieUI

internal object MostPopularDiff : DiffUtil.ItemCallback<MovieUI>() {
    override fun areItemsTheSame(
        oldItem: MovieUI,
        newItem: MovieUI
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: MovieUI,
        newItem: MovieUI
    ): Boolean {
        return oldItem == newItem
    }
}