package com.br.eldoradofilms.domain.mapper

import com.br.eldoradofilms.domain.model.Movie
import com.br.eldoradofilms.presentation.model.MoviesListUI
import org.junit.Test
import kotlin.test.assertEquals

class ObjectToPresentationMapperTest {

    private val mapper: HomeDomainMapper = HomeDomainMapper()

    @Test
    fun `when mapper should map to presentation`() {
        // When
        val result = mapper.map(Movie(id = "123"))

        // Then
        assertEquals(result, MoviesListUI(id = "123"))
    }
}