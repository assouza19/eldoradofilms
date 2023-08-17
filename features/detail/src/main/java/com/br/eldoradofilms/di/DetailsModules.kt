package com.br.eldoradofilms.di

import com.br.eldoradofilms.data.datasource.DetailRemoteDataSource
import com.br.eldoradofilms.data.datasource.DetailRemoteDataSourceImpl
import com.br.eldoradofilms.data.mapper.DetailsDataMapper
import com.br.eldoradofilms.data.repository.DetailsRepositoryImpl
import com.br.eldoradofilms.domain.mapper.DetailsDomainMapper
import com.br.eldoradofilms.domain.repository.DetailsRepository
import com.br.eldoradofilms.domain.usecase.GetMovieDetailsUseCase
import com.br.eldoradofilms.presentation.viewmodel.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailDataModules = module {
    factory<DetailRemoteDataSource> { DetailRemoteDataSourceImpl(api = get()) }
    factory<DetailsRepository> { DetailsRepositoryImpl(remoteDataSource = get(), map = get()) }
}

val detailDomainModules = module {
    factory { GetMovieDetailsUseCase(repository = get(), mapper = get()) }
    factory { DetailsDomainMapper() }
    factory { DetailsDataMapper() }
}

val detailPresentationModules = module {
    viewModel { DetailsViewModel(get()) }
}
