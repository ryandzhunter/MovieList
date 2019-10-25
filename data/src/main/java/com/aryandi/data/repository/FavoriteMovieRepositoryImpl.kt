package com.aryandi.data.repository

import com.aryandi.data.database.dao.FavoriteMovieDao
import com.aryandi.data.mapper.toData
import com.aryandi.data.mapper.toDomain
import com.aryandi.domain.model.MovieDomain
import com.aryandi.domain.repository.FavoriteMovieRepository

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version FavoriteMovieRepositoryImpl, v 0.1 2019-10-24 08:54 by Aryandi Putra
 */
class FavoriteMovieRepositoryImpl(private val favoriteMovieDao: FavoriteMovieDao) : FavoriteMovieRepository{

    override suspend fun insertFavoriteMovie(movieDomain: MovieDomain) {
        return favoriteMovieDao.insertMovie(toData(movieDomain))
    }

    override suspend fun removeFavoriteMovie(movieDomain: MovieDomain) {
        return favoriteMovieDao.removeMovie(toData(movieDomain))
    }

    override suspend fun getAllFavoriteMovies(): List<MovieDomain> =
        toDomain(favoriteMovieDao.getFavorites())

    override suspend fun isFavoriteMovieExist(movieDomain: MovieDomain): MovieDomain =
        toDomain(favoriteMovieDao.getMovie(movieDomain.id))
}