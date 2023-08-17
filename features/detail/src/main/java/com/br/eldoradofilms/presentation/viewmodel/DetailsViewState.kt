package com.br.eldoradofilms.presentation.viewmodel

import com.br.eldoradofilms.presentation.model.DetailUi

sealed class DetailsViewState(
    open val uiModel: DetailsUiModel = DetailsUiModel()
) {
    object InitialState : DetailsViewState()

    data class OnResume(
        override val uiModel: DetailsUiModel
    ) : DetailsViewState(uiModel)
}

data class DetailsUiModel(
    val result: DetailUi = DetailUi(),
    val isLoading: Boolean = false
)