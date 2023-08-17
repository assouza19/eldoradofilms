package com.br.eldoradofilms.domain.model

data class Detail(
    val backdropPath: String,
    val genres: List<String>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val tagline: String,
    val title: String,
    val voteAverage: Double
)
