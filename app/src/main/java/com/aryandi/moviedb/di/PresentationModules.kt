package com.aryandi.moviedb.di

import com.aryandi.moviedb.feature.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version PresentationModules, v 0.1 2019-10-21 10:45 by Aryandi Putra
 */
val presentasionModules = module() {
    viewModel{ HomeViewModel(get())}
}