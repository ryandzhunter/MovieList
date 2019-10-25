package com.aryandi.data.di

import androidx.room.Room
import com.aryandi.data.database.DB_NAME
import com.aryandi.data.database.FavoriteMovieDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version DatabaseModules, v 0.1 2019-10-23 13:41 by Aryandi Putra
 */
val dataBaseModules = module {
    single {
        Room.databaseBuilder(androidContext(), FavoriteMovieDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration().build()
    }
    factory {
        get<FavoriteMovieDatabase>().favoriteMovieDao()
    }
}