package com.br.eldoradofilms.domain.usecase

import com.br.eldoradofilms.domain.repository.HomeRepository
import com.br.eldoradofilms.presentation.model.MoviesListUI
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import kotlin.Result.Companion.success
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class GetFilmsListUseCaseTest {
    private val repository: HomeRepository = mock()
    private val useCase: GetFilmsListUseCase = GetFilmsListUseCase(repository)

    @Test
    fun `when invoke should return success`() = runBlockingTest {
        // Given
        whenever(repository.getFilms()).thenAnswer { success(MoviesListUI(id = "123")) }

        // When
        val result = useCase.invoke()

        val resultExpected = success(MoviesListUI(id = "123"))

        // Then
        assertEquals(result, resultExpected)
    }
}