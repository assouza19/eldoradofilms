package com.br.eldoradofilms.data.datasource

import com.br.eldoradofilms.data.repository.HomeRepositoryImpl
import com.br.eldoradofilms.domain.model.Movie
import com.br.eldoradofilms.domain.repository.HomeRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class RemoteDataSourceTest {

    private val dataSource: HomeRemoteDataSource = mock()

    private val repository: HomeRepository by lazy {
        HomeRepositoryImpl(dataSource)
    }

    @Test
    fun `When get from remote data source should return success`() = runBlockingTest {
        // Given
        whenever(dataSource.getFilms()).thenReturn(Movie(id = "12"))

        // When
        val result = repository.getFilms()

        // Then
        verify(dataSource).getFilms()
        assertEquals("12", result.getOrNull()!!.id)
    }
}