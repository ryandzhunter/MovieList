package com.aryandi.data.model

import com.aryandi.data.network.base.DomainMapper
import com.aryandi.domain.model.GenreDomain
import com.aryandi.domain.model.MovieDetailDomain
import com.aryandi.domain.model.ReviewDomain
import com.aryandi.domain.model.VideoDomain
import com.google.gson.annotations.SerializedName

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version MovieDetailData, v 0.1 2019-10-22 10:00 by Aryandi Putra
 */

data class MovieDetailData(

    @SerializedName("adult")
    var adult: Boolean = false,

    @SerializedName("budget")
    var budget: Int? = null,

    @SerializedName("genres")
    var genres: List<GenreData>? = null,

    @SerializedName("videos")
    var videos: VideoResult? = null,

    @SerializedName("reviews")
    var reviews: ReviewsResult? = null,

    @SerializedName("homepage")
    var homepage: String? = null,

    @SerializedName("id")
    var id: Int = -1,

    @SerializedName("imdb_id")
    var imdbId: String? = null,

    @SerializedName("popularity")
    var popularity: Float = 0F,

    @SerializedName("revenue")
    var revenue: Int? = null,

    @SerializedName("runtime")
    var runtime: Int? = null,

    @SerializedName("tagline")
    var tagline: String? = null,

    @SerializedName("video")
    var video: Boolean = false,

    @SerializedName("vote_average")
    var voteAverage: Float = 0F,

    @SerializedName("vote_count")
    var voteCount: Int = 0,

    @SerializedName("title")
    var title: String,

    @SerializedName("poster_path")
    var posterPath: String,

    @SerializedName("original_language")
    var originalLanguage: String,

    @SerializedName("original_title")
    var originalTitle: String,

    @SerializedName("backdrop_path")
    var backdropPath: String,

    @SerializedName("overview")
    var overview: String,

    @SerializedName("release_date")
    var releaseDate: String
) : DomainMapper<MovieDetailDomain> {
    override fun mapToDomainModel(): MovieDetailDomain {

        val genresDomain = arrayListOf<GenreDomain>()
        genres?.forEach {
            genresDomain.add(GenreDomain(it.id, it.name))
        }

        val videosDomain = arrayListOf<VideoDomain>()
        videos?.results?.forEach {
            videosDomain.add(VideoDomain(it.id, it.name, it.key, it.site, it.type))
        }

        val reviewsDomain = arrayListOf<ReviewDomain>()
        reviews?.results?.forEach {
            reviewsDomain.add(ReviewDomain(it.id, it.author, it.content))
        }

        return MovieDetailDomain(
            adult,
            budget,
            genresDomain,
            videosDomain,
            reviewsDomain,
            homepage,
            id,
            imdbId,
            popularity,
            revenue,
            runtime,
            tagline,
            video,
            voteAverage,
            voteCount,
            title,
            posterPath,
            originalLanguage,
            originalTitle,
            backdropPath,
            overview,
            releaseDate
        )
    }

    data class GenreData(
        var id: Int,
        var name: String
    )

    class VideoResult {
        var results: List<VideoData>? = null
    }

    data class VideoData(
        var id: String,
        var name: String,
        var key: String? = null,
        var site: String? = null,
        var type: String? = null
    )

    class ReviewsResult {
        var results: List<ReviewData>? = null
    }

    data class ReviewData(
        var id: String,
        var author: String,
        var content: String? = null
    )
}


