package br.com.common.data.api

import br.com.common.data.model.DetailDTO
import br.com.common.data.model.MoviesListDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EldoradoFilmsService {

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

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = "pt-BR"
    ): Response<DetailDTO>
}