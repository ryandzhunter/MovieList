package com.aryandi.data.database.dao

import androidx.room.*
import com.aryandi.data.MovieData

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version FavoriteMovieDao, v 0.1 2019-10-23 13:03 by Aryandi Putra
 */
@Dao
interface FavoriteMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(favoriteMovieData: MovieData) : Long

    @Delete
    suspend fun removeMovie(favoriteMovieData: MovieData) : Int

    @Query("SELECT * FROM favorite_movies")
    suspend fun getFavorites(): List<MovieData>

    @Query("SELECT * FROM favorite_movies WHERE id=:movieId")
    suspend fun getMovie(movieId: Int?): MovieData?
}