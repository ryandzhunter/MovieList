package com.aryandi.moviedb

import android.app.Application
import com.aryandi.data.di.dataBaseModules
import com.aryandi.data.di.networkModules
import com.aryandi.data.di.repositoryModules
import com.aryandi.domain.di.useCaseModules
import com.aryandi.moviedb.di.presentasionModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version MainApplication, v 0.1 2019-10-15 15:47 by Aryandi Putra
 */

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(networkModules, dataBaseModules,
                repositoryModules, useCaseModules, presentasionModules))        }
    }
}