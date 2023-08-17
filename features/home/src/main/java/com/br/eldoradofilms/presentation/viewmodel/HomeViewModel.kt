package com.br.eldoradofilms.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.eldoradofilms.domain.usecase.GetMovieListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val useCase: GetMovieListUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow<HomeViewState>(HomeViewState.InitialState)
    val viewState: StateFlow<HomeViewState> = _viewState

    private val _viewAction = MutableLiveData<HomeViewAction>()
    val viewAction: LiveData<HomeViewAction> = _viewAction

    fun onViewCreated() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                useCase()
            }.onSuccess {
                _viewState.value = HomeViewState.OnResume(
                    getCurrentUiModel().copy(
                        list = it, isLoading = false
                    )
                )
            }.onFailure {
                showErrorScreen()
            }
        }
    }


    private fun showErrorScreen() {
        _viewAction.postValue(HomeViewAction.ShowErrorScreen)
    }

    private fun getCurrentUiModel() = checkNotNull(_viewState.value.uiModel)
}