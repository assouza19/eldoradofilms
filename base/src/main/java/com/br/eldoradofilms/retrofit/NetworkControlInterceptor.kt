package com.br.eldoradofilms.retrofit

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

const val TOKEN =
    "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5ZjMzNjE3NTcyYmUwNmE2NzVhZWUzYzgyZGE0Y2E0NiIsInN1YiI6IjViYjYyYzk3YzNhMzY4MTUyNjAwZGVhMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.P-blyoGl2L01BeEWBN05crh9zQiChU6m9UcK6rZqZFk"
const val TEN_UNIT = 10

object NetworkInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()

        val newRequest: Request = originalRequest.newBuilder()
            .header("Authorization", "Bearer $TOKEN")
            .build()

        return chain.proceed(newRequest)
    }
}