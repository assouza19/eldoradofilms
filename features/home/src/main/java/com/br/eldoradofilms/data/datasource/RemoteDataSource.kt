package com.br.eldoradofilms.data.datasource

import com.br.eldoradofilms.domain.model.MoviesList

interface RemoteDataSource {

    suspend fun getFilms(): MoviesList
    suspend fun getPopularMovies(): MoviesList
    suspend fun getRelated()
}