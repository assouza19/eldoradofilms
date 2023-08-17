package com.br.eldoradofilms.domain.mapper

import com.br.eldoradofilms.domain.model.MoviesList
import com.br.eldoradofilms.presentation.model.MovieUI
import com.br.eldoradofilms.utils.Mapper

class HomeDomainMapper : Mapper<MoviesList, List<MovieUI>> {

    override fun map(source: MoviesList): List<MovieUI> {
        return source.movies.map {
            MovieUI(
                id = it.id,
                adult = it.adult,
                backdropPath = it.backdropPath,
                genreIds = it.genreIds,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                video = it.video,
                voteAverage = it.voteAverage
            )
        }
    }
}