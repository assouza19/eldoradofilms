package com.br.eldoradofilms.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.br.eldoradofilms.domain.usecase.GetMovieListUseCase
import com.br.eldoradofilms.presentation.model.MoviesListUI
import com.br.eldoradofilms.presentation.viewmodel.HomeViewModel
import com.br.eldoradofilms.utils.MainCoroutineRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import kotlin.Result.Companion.success
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val useCase: GetMovieListUseCase = mock()
    private val viewModel: HomeViewModel by lazy {
        HomeViewModel(useCase)
    }

    @Test
    fun `exampleCallCoroutines should call use case`() = runBlockingTest {
        // Given
        whenever(useCase.invoke()).thenAnswer { success(MoviesListUI(id = "123")) }

        // When
        viewModel.onViewCreated()

        val response = viewModel.resultSuccess.value!!.isSuccess

        // Then
        verify(useCase).invoke()
        assertTrue(response)
    }
}
