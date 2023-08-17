package com.br.eldoradofilms.data.datasource

import br.com.common.data.api.EldoradoFilmsService
import com.br.eldoradofilms.data.mapper.ObjectToDomainMapper
import br.com.common.data.model.MoviesListDTO
import com.br.eldoradofilms.domain.model.MoviesList

class RemoteDataSourceImpl(
    private val api: EldoradoFilmsService
) : HomeRemoteDataSource {

    private val mapper: ObjectToDomainMapper = ObjectToDomainMapper()

    override suspend fun getFilms(): MoviesList {
        val response = api.getPopularFilms()
        return if (response.isSuccessful) {
            checkBody(response.body())
        } else {
            throw Exception()
        }
    }

    override suspend fun getPopularMovies(): MoviesList {
        val response = api.getPopularFilms()
        return if (response.isSuccessful) {
            checkBody(response.body())
        } else {
            throw Exception()
        }
    }

    override suspend fun getRelated() {
    }

    private fun checkBody(data: MoviesListDTO?): MoviesList {
        return if (data == null || data.movies.isEmpty()) {
            throw EmptyListException
        } else {
            mapper.map(data)
        }
    }
}

object EmptyListException : Exception()
