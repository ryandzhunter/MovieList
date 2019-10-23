package com.aryandi.data.network

import com.aryandi.data.MovieResponse
import com.aryandi.data.model.MovieDetailData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version MovieApi, v 0.1 2019-10-15 18:48 by Aryandi Putra
 */

interface MovieApi {

    @GET("authentication/guest_session/new")
    fun createGuestSession()

    @GET("authentication/token/new")
    fun createRequestToken()

    @GET("discover/movie")
    suspend fun getMovies(): Response<MovieResponse>

    @GET("movie/{id}?append_to_response=videos,reviews")
    suspend fun getMovieDetails(@Path("id") movieId: Int) : Response<MovieDetailData>

    @GET("search/movie")
    fun searchMovie(@Query("query") q: String): Call<MovieResponse>

    @GET("discover/movie")
    fun getMovies(
        @Query("primary_release_date.lte") releaseDate: String,
        @Query("sort_by") sortBy: String, @Query("page") page: Int
    )

    @GET("movie/{type}")
    fun getTypeMovies(@Path("type") type: String)

    @GET("search/movie")
    fun searchMovies(@Query("query") query: String)

}