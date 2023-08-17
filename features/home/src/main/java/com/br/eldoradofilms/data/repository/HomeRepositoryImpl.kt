package com.br.eldoradofilms.data.repository

import com.br.eldoradofilms.data.datasource.HomeRemoteDataSource
import com.br.eldoradofilms.domain.model.MoviesList
import com.br.eldoradofilms.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val remoteDataSource: HomeRemoteDataSource
) : HomeRepository {

    override suspend fun getFilms(): MoviesList {
        return remoteDataSource.getFilms()
    }

    override suspend fun getPopularFilms(): MoviesList {
        return remoteDataSource.getPopularMovies()
    }
}