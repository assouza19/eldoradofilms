package com.br.eldoradofilms.retrofit

import retrofit2.Retrofit

class HttpClient(private val retrofit: Retrofit) {

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}