package com.aryandi.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aryandi.data.MovieData
import com.aryandi.data.database.dao.FavoriteMovieDao
import com.aryandi.data.database.typeconverter.GenreConverter

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version FavoriteMovieDatabase, v 0.1 2019-10-23 13:43 by Aryandi Putra
 */
@Database(entities = [MovieData::class], version = 1, exportSchema = false)
@TypeConverters(GenreConverter::class)
abstract class FavoriteMovieDatabase : RoomDatabase() {
    abstract fun favoriteMovieDao() : FavoriteMovieDao
}