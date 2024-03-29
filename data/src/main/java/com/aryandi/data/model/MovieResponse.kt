package com.aryandi.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aryandi.data.database.DB_FAVORITE_MOVIE_TABLE_NAME
import com.aryandi.data.network.base.DomainMapper
import com.aryandi.domain.model.MovieDomain
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version MovieResponse, v 0.1 2019-10-17 10:20 by Aryandi Putra
 */

class MovieResponse(
    @SerializedName("page")
    @Expose
    var page: Int? = null,
    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null,
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null,
    @SerializedName("results")
    @Expose
    var results: List<MovieData>? = null
) : DomainMapper<List<MovieDomain>> {

    override fun mapToDomainModel(): List<MovieDomain> {
        val moviesDomain = arrayListOf<MovieDomain>()
        results?.forEach{
            moviesDomain.add(
                MovieDomain(
                    it.voteCount,
                    it.id,
                    it.video,
                    it.voteAverage,
                    it.title,
                    it.popularity,
                    it.posterPath,
                    it.originalLanguage,
                    it.originalTitle,
                    it.genreIds,
                    it.backdropPath,
                    it.adult,
                    it.overview,
                    it.releaseDate,
                    it.isFavorite
                )
            )
        }
        return moviesDomain
    }

}

@Entity(tableName = DB_FAVORITE_MOVIE_TABLE_NAME)
data class MovieData(
    @SerializedName("vote_count")
    @Expose
    var voteCount: Int? = null,
    @SerializedName("id")
    @Expose
    @PrimaryKey
    var id: Int? = null,
    @SerializedName("video")
    @Expose
    var video: Boolean? = null,
    @SerializedName("vote_average")
    @Expose
    var voteAverage: Float? = null,
    @SerializedName("title")
    @Expose
    var title: String? = null,
    @SerializedName("popularity")
    @Expose
    var popularity: Float? = null,
    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null,
    @SerializedName("original_language")
    @Expose
    var originalLanguage: String? = null,
    @SerializedName("original_title")
    @Expose
    var originalTitle: String? = null,
    @SerializedName("genre_ids")
    @Expose
    var genreIds: List<Int>? = null,
    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String? = null,
    @SerializedName("adult")
    @Expose
    var adult: Boolean? = null,
    @SerializedName("overview")
    @Expose
    var overview: String? = null,
    @SerializedName("release_date")
    @Expose
    var releaseDate: String? = null,
    var isFavorite: Boolean? = null)