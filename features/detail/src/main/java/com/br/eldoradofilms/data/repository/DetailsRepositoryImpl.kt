package com.br.eldoradofilms.data.repository

import com.br.eldoradofilms.data.datasource.DetailRemoteDataSource
import com.br.eldoradofilms.data.mapper.DetailsDataMapper
import com.br.eldoradofilms.domain.mapper.DetailsDomainMapper
import com.br.eldoradofilms.domain.model.Detail
import com.br.eldoradofilms.domain.repository.DetailsRepository

class DetailsRepositoryImpl(
    private val remoteDataSource: DetailRemoteDataSource,
    private val map: DetailsDataMapper
) : DetailsRepository {

    override suspend fun getMovieDetails(movieId: Int): Detail {
        return map.map(remoteDataSource.getDetails(movieId))
    }
}