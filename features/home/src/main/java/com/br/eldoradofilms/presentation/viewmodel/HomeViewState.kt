package com.br.eldoradofilms.presentation.viewmodel

import com.br.eldoradofilms.presentation.model.MovieUI

sealed class HomeViewState(
    open val uiModel: HomeUiModel = HomeUiModel()
) {
    object InitialState : HomeViewState()

    data class OnResume(
        override val uiModel: HomeUiModel
    ) : HomeViewState(uiModel)
}

data class HomeUiModel(
    val list: List<MovieUI> = listOf(),
    val isLoading: Boolean = false
)