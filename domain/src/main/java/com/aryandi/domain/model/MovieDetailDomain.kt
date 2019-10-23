package com.aryandi.domain.model

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version MovieDetailDomain, v 0.1 2019-10-22 10:34 by Aryandi Putra
 */
data class MovieDetailDomain(

    var adult: Boolean = false,
    var budget: Int? = null,
    var genres: List<GenreDomain>? = null,
    var videos: List<VideoDomain>? = null,
    var reviews: List<ReviewDomain>? = null,
    var homepage: String? = null,
    var id: Int = -1,
    var imdbId: String? = null,
    var popularity: Double = 0.0,
    var revenue: Int? = null,
    var runtime: Int? = null,
    var tagline: String? = null,
    var video: Boolean = false,
    var voteAverage: Double = 0.0,
    var voteCount: Int = 0,
    var title: String,
    var posterPath: String,
    var originalLanguage: String,
    var originalTitle: String,
    var backdropPath: String? = null,
    var overview: String,
    var releaseDate: String
)

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


