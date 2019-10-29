package com.aryandi.domain.repository

import com.aryandi.domain.model.MovieDomain
import com.aryandi.domain.model.Result

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version FavoriteMovieRepository, v 0.1 2019-10-24 08:55 by Aryandi Putra
 */
interface FavoriteMovieRepository{
    suspend fun insertFavoriteMovie(movieDomain: MovieDomain) : Result<Long>
    suspend fun removeFavoriteMovie(movieDomain: MovieDomain) : Result<Int>
    suspend fun getAllFavoriteMovies(): Result<List<MovieDomain>>
    suspend fun isFavoriteMovieExist(movieId: Int) : Result<MovieDomain>
}