package com.aryandi.data.repository

import com.aryandi.data.database.dao.FavoriteMovieDao
import com.aryandi.data.mapper.toData
import com.aryandi.data.mapper.toDomain
import com.aryandi.domain.model.*
import com.aryandi.domain.repository.FavoriteMovieRepository

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version FavoriteMovieRepositoryImpl, v 0.1 2019-10-24 08:54 by Aryandi Putra
 */
class FavoriteMovieRepositoryImpl(private val favoriteMovieDao: FavoriteMovieDao) :
    BaseRepository(), FavoriteMovieRepository {

    override suspend fun insertFavoriteMovie(movieDomain: MovieDomain): Result<Long> {
        return try {
            val favoriteMovieData = toData(movieDomain)
            Success(favoriteMovieDao.insertMovie(favoriteMovieData))
        } catch (e: Exception) {
            Failure(Error(Throwable(e.message)))
        }
    }

    override suspend fun removeFavoriteMovie(movieDomain: MovieDomain): Result<Int> {
        return try {
            val favoriteMovieData = toData(movieDomain)
            Success(favoriteMovieDao.removeMovie(favoriteMovieData))
        } catch (e: Exception) {
            Failure(Error(Throwable(e.message)))
        }
    }

    override suspend fun getAllFavoriteMovies(): Result<List<MovieDomain>> {
        return try {
            val movieDatas = favoriteMovieDao.getFavorites()
            Success(toDomain(movieDatas))
        } catch (e: Exception) {
            Failure(Error(Throwable(e.message)))
        }
    }

    override suspend fun isFavoriteMovieExist(movieId: Int): Result<MovieDomain> {
        return try {
            val movieData = favoriteMovieDao.getMovie(movieId)
            if (movieData != null) Success(toDomain(movieData)) else Success(MovieDomain())
        } catch (e: Exception) {
            Failure(Error(Throwable(e.message)))
        }
    }
}