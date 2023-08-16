package com.br.eldoradofilms.domain.usecase

import com.br.eldoradofilms.domain.mapper.DomainToPresentationMapper
import com.br.eldoradofilms.domain.repository.HomeRepository

class GetFilmsListUseCase(
    private val repository: HomeRepository,
    private val mapper: DomainToPresentationMapper
) {
    suspend operator fun invoke() = mapper.map(repository.getFilms())
}