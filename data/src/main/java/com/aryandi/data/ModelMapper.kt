package com.aryandi.data.mapper

import com.aryandi.data.MovieData
import com.aryandi.domain.model.MovieDomain

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version ModelMapper, v 0.1 2019-10-23 14:39 by Aryandi Putra
 */
fun toData(movieDomain: MovieDomain) = MovieData(
    movieDomain.voteCount,
    movieDomain.id,
    movieDomain.video,
    movieDomain.voteAverage,
    movieDomain.title,
    movieDomain.popularity,
    movieDomain.posterPath,
    movieDomain.originalLanguage,
    movieDomain.originalTitle,
    movieDomain.genreIds,
    movieDomain.backdropPath,
    movieDomain.adult,
    movieDomain.overview,
    movieDomain.releaseDate
)

fun toDomain(movieData: MovieData) = MovieDomain(
    movieData.voteCount,
    movieData.id,
    movieData.video,
    movieData.voteAverage,
    movieData.title,
    movieData.popularity,
    movieData.posterPath,
    movieData.originalLanguage,
    movieData.originalTitle,
    movieData.genreIds,
    movieData.backdropPath,
    movieData.adult,
    movieData.overview,
    movieData.releaseDate
)

fun toDomain(movieDatas: List<MovieData>): List<MovieDomain> {
    return movieDatas.map { toDomain(it)
    }
}