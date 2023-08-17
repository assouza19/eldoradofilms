package com.br.eldoradofilms.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.eldoradofilms.domain.usecase.GetMovieDetailsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val useCase: GetMovieDetailsUseCase
) : ViewModel() {
    private val _viewState = MutableStateFlow<DetailsViewState>(DetailsViewState.InitialState)
    val viewState: StateFlow<DetailsViewState> = _viewState

    private val _viewAction = MutableLiveData<DetailsViewAction>()
    val viewAction: LiveData<DetailsViewAction> = _viewAction

    fun onViewCreated(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                useCase(movieId)
            }.onSuccess {
                _viewState.value = DetailsViewState.OnResume(
                    getCurrentUiModel().copy(
                        result = it,
                        isLoading = false
                    )
                )
            }.onFailure {
                showErrorScreen()
            }
        }
    }

    private fun showErrorScreen() {
        _viewAction.postValue(DetailsViewAction.ShowErrorScreen)
    }

    private fun getCurrentUiModel() = checkNotNull(_viewState.value.uiModel)
}