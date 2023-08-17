package com.br.eldoradofilms.domain.repository

import com.br.eldoradofilms.domain.model.Detail

interface DetailsRepository {
    suspend fun getMovieDetails(movieId: Int): Detail
}