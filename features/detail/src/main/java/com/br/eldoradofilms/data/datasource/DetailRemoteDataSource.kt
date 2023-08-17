package com.br.eldoradofilms.data.datasource

import br.com.common.data.model.DetailDTO

interface DetailRemoteDataSource {
    suspend fun getDetails(movieId: Int): DetailDTO
}