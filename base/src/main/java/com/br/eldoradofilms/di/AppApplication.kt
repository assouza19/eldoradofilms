package com.br.eldoradofilms.di

import android.app.Application
import br.com.common.data.api.EldoradoFilmsService
import com.br.eldoradofilms.retrofit.HttpClient
import com.br.eldoradofilms.retrofit.RetrofitClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(domainModules)
            modules(detailPresentationModules)
            modules(detailDataModules)
            modules(detailDomainModules)
            modules(dataModules)
            modules(presentationModules)
            modules(networkModules)
            modules(anotherModules)
        }
    }

    private val networkModules = module {
        single { RetrofitClient().newInstance() }
        single { HttpClient(get()) }
        single { get<HttpClient>().create(EldoradoFilmsService::class.java) }
    }
}