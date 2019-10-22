package com.aryandi.data.di

import com.aryandi.data.common.utils.Connectivity
import com.aryandi.data.common.utils.ConnectivityImpl
import com.aryandi.data.repository.MovieRepositoryImpl
import com.aryandi.domain.repository.MovieRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version RepositoryModules, v 0.1 2019-10-21 22:42 by Aryandi Putra
 */
val repositoryModules = module {
    factory<MovieRepository> { MovieRepositoryImpl(get())}
    factory<Connectivity> { ConnectivityImpl(androidContext()) }
}