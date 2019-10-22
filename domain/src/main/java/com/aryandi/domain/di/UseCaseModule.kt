package com.aryandi.domain.di

import com.aryandi.domain.usecase.GetMoviesUseCase
import com.aryandi.domain.usecase.GetMoviesUseCaseImpl
import org.koin.dsl.module

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version UseCaseModule, v 0.1 2019-10-18 16:59 by Aryandi Putra
 */
val useCaseModules = module {
    factory<GetMoviesUseCase> { GetMoviesUseCaseImpl(get()) }
}