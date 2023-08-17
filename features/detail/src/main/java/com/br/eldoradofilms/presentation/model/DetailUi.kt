package com.br.eldoradofilms.presentation.model

data class DetailUi(
    val backdropPath: String = "",
    val genres: List<String> = listOf(),
    val homepage: String = "",
    val id: Int = 0,
    val imdbId: String = "",
    val originalLanguage: String = "",
    val originalTitle: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val posterPath: String = "",
    val tagline: String = "",
    val title: String = "",
    val voteAverage: Double = 0.0
)