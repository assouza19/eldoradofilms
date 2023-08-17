package com.br.eldoradofilms.domain.mapper

import com.br.eldoradofilms.domain.model.Detail
import com.br.eldoradofilms.presentation.model.DetailUi
import com.br.eldoradofilms.utils.Mapper

class DetailsDomainMapper: Mapper<Detail, DetailUi> {

    override fun map(source: Detail): DetailUi {
        return DetailUi(
            id = source.id,
            imdbId = source.imdbId,
            backdropPath = source.backdropPath,
            genres = source.genres.map { it },
            homepage = source.homepage,
            originalLanguage = source.originalLanguage,
            originalTitle = source.originalTitle,
            overview = source.overview,
            popularity = source.popularity,
            posterPath = source.posterPath,
            tagline = source.tagline,
            title = source.title,
            voteAverage = source.voteAverage
        )
    }
}