package com.aryandi.moviedb.feature.home

import com.aryandi.domain.model.MovieDomain
import com.aryandi.domain.model.onFailure
import com.aryandi.domain.model.onSuccess
import com.aryandi.domain.usecase.GetMoviesUseCase
import com.aryandi.domain.usecase.GetPopularMoviesUseCase
import com.aryandi.domain.usecase.GetTopRatedMoviesUseCase
import com.aryandi.moviedb.base.BaseViewModel
import com.aryandi.moviedb.base.Error
import com.aryandi.moviedb.base.Success

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version HomeViewModel, v 0.1 2019-10-15 16:01 by Aryandi Putra
 */
class HomeViewModel(private val getMovies: GetMoviesUseCase,
                    private val getPopularMovies: GetPopularMoviesUseCase,
                    private val getTopRatedMovies: GetTopRatedMoviesUseCase) :
    BaseViewModel<List<MovieDomain>, HomeViewEffects>() {

    fun loadMovies() = executeUseCase {
        getMovies.invoke("").onSuccess { _viewState.value = Success(it) }
            .onFailure { _viewState.value = Error(it.throwable) }
    }

    fun loadPopularMovies() = executeUseCase{
        getPopularMovies.invoke("").onSuccess { _viewState.value = Success(it) }
            .onFailure { _viewState.value = Error(it.throwable) }
    }

    fun loadTopRatedMovies() = executeUseCase{
        getTopRatedMovies.invoke("").onSuccess { _viewState.value = Success(it) }
            .onFailure { _viewState.value = Error(it.throwable) }
    }
}
