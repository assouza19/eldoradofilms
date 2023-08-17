package com.br.eldoradofilms.domain.usecase

import com.br.eldoradofilms.domain.mapper.DetailsDomainMapper
import com.br.eldoradofilms.domain.repository.DetailsRepository
import com.br.eldoradofilms.presentation.model.DetailUi

class GetMovieDetailsUseCase(
    private val repository: DetailsRepository,
    private val mapper: DetailsDomainMapper
) {
    suspend operator fun invoke(movieId: Int): DetailUi {
        return mapper.map(repository.getMovieDetails(movieId))
    }
}