package com.aryandi.domain.repository

import com.aryandi.domain.model.MovieDomain

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version FavoriteMovieRepository, v 0.1 2019-10-24 08:55 by Aryandi Putra
 */
interface FavoriteMovieRepository{
    suspend fun insertFavoriteMovie(movieDomain: MovieDomain)
    suspend fun removeFavoriteMovie(movieDomain: MovieDomain)
    suspend fun getAllFavoriteMovies(): List<MovieDomain>
    suspend fun isFavoriteMovieExist(movieDomain: MovieDomain) : MovieDomain
}