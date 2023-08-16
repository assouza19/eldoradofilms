package com.br.eldoradofilms.data.repository

import com.br.eldoradofilms.data.datasource.RemoteDataSource
import com.br.eldoradofilms.domain.model.Movie
import com.br.eldoradofilms.domain.model.MoviesList
import com.br.eldoradofilms.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : HomeRepository {

    override suspend fun getFilms(): MoviesList {
        return remoteDataSource.getFilms()
    }

    override suspend fun getPopularFilms(): MoviesList {
        return remoteDataSource.getPopularMovies()
    }
}