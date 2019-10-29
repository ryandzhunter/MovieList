package com.aryandi.domain.model

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version MovieDomain, v 0.1 2019-10-17 10:20 by Aryandi Putra
 */

data class MovieDomain(
    var voteCount: Int? = null,
    var id: Int? = null,
    var video: Boolean? = null,
    var voteAverage: Float? = null,
    var title: String? = null,
    var popularity: Float? = null,
    var posterPath: String? = null,
    var originalLanguage: String? = null,
    var originalTitle: String? = null,
    var genreIds: List<Int>? = null,
    var backdropPath: String? = null,
    var adult: Boolean? = null,
    var overview: String? = null,
    var releaseDate: String? = null,
    var isFavorite: Boolean? = null)