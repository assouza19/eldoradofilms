package com.br.eldoradofilms.domain.usecase

import com.br.eldoradofilms.domain.mapper.HomeDomainMapper
import com.br.eldoradofilms.domain.repository.HomeRepository

class GetMovieListUseCase(
    private val repository: HomeRepository,
    private val mapper: HomeDomainMapper
) {
    suspend operator fun invoke() = mapper.map(repository.getFilms())
}