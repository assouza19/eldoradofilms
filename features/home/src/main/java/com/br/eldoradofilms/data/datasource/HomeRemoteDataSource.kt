package com.br.eldoradofilms.data.datasource

import com.br.eldoradofilms.domain.model.MoviesList

interface HomeRemoteDataSource {

    suspend fun getFilms(): MoviesList
    suspend fun getPopularMovies(): MoviesList
    suspend fun getRelated()
}