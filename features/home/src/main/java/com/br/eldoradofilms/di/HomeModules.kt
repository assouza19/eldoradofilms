package com.br.eldoradofilms.di

import com.br.eldoradofilms.data.datasource.HomeRemoteDataSource
import com.br.eldoradofilms.data.datasource.RemoteDataSourceImpl
import com.br.eldoradofilms.data.repository.HomeRepositoryImpl
import com.br.eldoradofilms.domain.mapper.HomeDomainMapper
import com.br.eldoradofilms.domain.repository.HomeRepository
import com.br.eldoradofilms.domain.usecase.GetMovieListUseCase
import com.br.eldoradofilms.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModules = module {
    factory { GetMovieListUseCase(repository = get(), mapper = get()) }
    factory { HomeDomainMapper() }
}

val presentationModules = module {
    viewModel { HomeViewModel(useCase = get()) }
}

val dataModules = module {
    factory<HomeRemoteDataSource> { RemoteDataSourceImpl(api = get()) }
    factory<HomeRepository> { HomeRepositoryImpl(remoteDataSource = get()) }
}

val anotherModules = module {}
