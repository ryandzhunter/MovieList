package com.aryandi.domain.model

import com.aryandi.domain.model.MovieDomain

data class MovieDetailDomain(

    var adult: Boolean = false,
    var budget: Int? = null,
    var genres: List<GenreDomain>? = null,
    var videos: List<VideoDomain>? = null,
    var reviews: List<ReviewDomain>? = null,
    var homepage: String? = null,
    var id: Int = -1,
    var imdbId: String? = null,
    var popularity: Float = 0F,
    var revenue: Int? = null,
    var runtime: Int? = null,
    var tagline: String? = null,
    var video: Boolean = false,
    var voteAverage: Float = 0F,
    var voteCount: Int = 0,
    var title: String,
    var posterPath: String,
    var originalLanguage: String,
    var originalTitle: String,
    var backdropPath: String? = null,
    var overview: String,
    var releaseDate: String
)

fun toMovieDomain(movieDetailDomain: MovieDetailDomain): MovieDomain {
    movieDetailDomain.let {
        val genresId = arrayListOf<Int>()
        it.genres?.forEach {
            genresId.add(it.id)
        }
        return MovieDomain(
            it.voteCount,
            it.id,
            it.video,
            it.voteAverage,
            it.title,
            it.popularity,
            it.posterPath,
            it.originalLanguage,
            it.originalTitle,
            genresId,
            it.backdropPath,
            it.adult,
            it.overview
        )
    }
}

data class GenreDomain(
    var id: Int,
    var name: String
)

data class VideoDomain(
    var id: String,
    var name: String,
    var key: String? = null,
    var site: String? = null,
    var type: String? = null
)

data class ReviewDomain(
    var id: String,
    var author: String,
    var content: String? = null
)


