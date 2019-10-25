package com.aryandi.domain.di

import com.aryandi.domain.usecase.*
import org.koin.dsl.module

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version UseCaseModule, v 0.1 2019-10-18 16:59 by Aryandi Putra
 */
val useCaseModules = module {
    factory<GetMoviesUseCase> { GetMoviesUseCaseImpl(get()) }
    factory<GetMovieDetailUseCase> { GetMovieDetailUseCaseImpl(get())}
    factory<GetTopRatedMoviesUseCase> { GetTopRatedMoviesUseCaseImpl(get())}
    factory<GetPopularMoviesUseCase> { GetPopularMoviesUseCaseImpl(get())}
    factory<SaveFavoriteMovieUseCase> { SaveFavoriteMovieUseCaseImpl(get())}
    factory<RemoveFavoriteMovieUseCase> { RemoveFavoriteMovieUseCaseImpl(get()) }
    factory<GetAllFavoriteMoviesUseCase> { GetAllFavoriteMoviesUseCaseImpl(get()) }
    factory<IsFavoriteMovieExistUseCase> { IsFavoriteMovieExistUseCaseImpl(get()) }
}