package com.br.eldoradofilms.data.mapper

import br.com.common.data.model.MoviesListDTO
import com.br.eldoradofilms.domain.model.Movie
import com.br.eldoradofilms.domain.model.MoviesList
import com.br.eldoradofilms.utils.Mapper

class ObjectToDomainMapper : Mapper<MoviesListDTO, MoviesList> {

    override fun map(source: MoviesListDTO): MoviesList {
        return MoviesList(
            movies = source.movies.map {
                Movie(
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
        )
    }
}