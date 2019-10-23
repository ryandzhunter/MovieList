package com.aryandi.moviedb.feature.detail

import com.aryandi.domain.model.MovieDetailDomain
import com.aryandi.domain.model.onFailure
import com.aryandi.domain.model.onSuccess
import com.aryandi.domain.usecase.GetMovieDetailUseCase
import com.aryandi.moviedb.base.BaseViewModel
import com.aryandi.moviedb.base.Error
import com.aryandi.moviedb.base.Success
import com.aryandi.moviedb.feature.home.HomeViewEffects

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version MovieDetailViewModel, v 0.1 2019-10-22 10:08 by Aryandi Putra
 */
class MovieDetailViewModel(private val useCase: GetMovieDetailUseCase)
    : BaseViewModel<MovieDetailDomain, HomeViewEffects>() {

    fun getMovieDetail(id : Int) = executeUseCase {
        useCase.invoke(id).onSuccess { _viewState.value = Success(it) }
            .onFailure { _viewState.value = Error(it.throwable) }
    }
}