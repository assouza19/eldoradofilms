package com.br.eldoradofilms.data.api

import com.br.eldoradofilms.data.model.MoviesListDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("/endpoint/example")
    suspend fun getFilms(
        @Query("page") page: Int,
        @Query("language") language: String = "pt-BR"
    ): MoviesListDTO

    @GET("movie/popular")
    suspend fun getPopularFilms(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "pt-BR"
    ): Response<MoviesListDTO>

    @GET("/endpoint/example")
    suspend fun getRelated()
}