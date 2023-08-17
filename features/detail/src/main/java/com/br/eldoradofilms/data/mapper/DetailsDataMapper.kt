package com.br.eldoradofilms.data.mapper

import br.com.common.data.model.DetailDTO
import com.br.eldoradofilms.domain.model.Detail
import com.br.eldoradofilms.utils.Mapper

class DetailsDataMapper: Mapper<DetailDTO, Detail> {

    override fun map(source: DetailDTO): Detail {
        return Detail(
            id = source.id,
            imdbId = source.imdbId,
            backdropPath = source.backdropPath,
            genres = source.genres.map { it.name },
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