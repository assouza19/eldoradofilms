package com.br.eldoradofilms.domain.repository

import com.br.eldoradofilms.domain.model.MoviesList

interface HomeRepository {

    suspend fun getFilms(): MoviesList
    suspend fun getPopularFilms(): MoviesList
}