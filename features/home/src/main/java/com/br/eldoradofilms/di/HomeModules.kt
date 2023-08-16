package com.br.eldoradofilms.di

import android.content.Context
import com.br.eldoradofilms.data.datasource.RemoteDataSource
import com.br.eldoradofilms.data.datasource.RemoteDataSourceImpl
import com.br.eldoradofilms.data.repository.HomeRepositoryImpl
import com.br.eldoradofilms.domain.mapper.DomainToPresentationMapper
import com.br.eldoradofilms.domain.repository.HomeRepository
import com.br.eldoradofilms.domain.usecase.GetFilmsListUseCase
import com.br.eldoradofilms.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModules = module {
    factory { GetFilmsListUseCase(repository = get(), mapper = get()) }
    factory { DomainToPresentationMapper() }
}

val presentationModules = module {
    viewModel { HomeViewModel(useCase = get()) }
}

val dataModules = module {
    factory<RemoteDataSource> { RemoteDataSourceImpl(api = get()) }
    factory<HomeRepository> { HomeRepositoryImpl(remoteDataSource = get()) }
}

val anotherModules = module {}
