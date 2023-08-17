package com.br.eldoradofilms.data.datasource

import br.com.common.data.api.EldoradoFilmsService
import br.com.common.data.model.DetailDTO

class DetailRemoteDataSourceImpl(
    val api: EldoradoFilmsService
) : DetailRemoteDataSource {

    override suspend fun getDetails(movieId: Int): DetailDTO {
        val response = api.getMovieDetails(movieId)

        return if (response.isSuccessful) {
            checkBody(response.body())
        } else {
            throw Exception()
        }
    }

    private fun checkBody(data: DetailDTO?): DetailDTO {
        return data ?: throw EmptyDetailException
    }
}

object EmptyDetailException : Exception()