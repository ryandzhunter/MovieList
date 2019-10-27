package com.aryandi.moviedb.feature.detail

import androidx.lifecycle.MutableLiveData
import com.aryandi.domain.model.MovieDetailDomain
import com.aryandi.domain.model.MovieDomain
import com.aryandi.domain.model.onFailure
import com.aryandi.domain.model.onSuccess
import com.aryandi.domain.usecase.GetMovieDetailUseCase
import com.aryandi.domain.usecase.IsFavoriteMovieExistUseCase
import com.aryandi.domain.usecase.RemoveFavoriteMovieUseCase
import com.aryandi.domain.usecase.SaveFavoriteMovieUseCase
import com.aryandi.moviedb.base.BaseViewModel
import com.aryandi.moviedb.base.Error
import com.aryandi.moviedb.base.Success
import com.aryandi.moviedb.feature.home.HomeViewEffects

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version MovieDetailViewModel, v 0.1 2019-10-22 10:08 by Aryandi Putra
 */
class MovieDetailViewModel(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val saveFavoriteMovieUseCase: SaveFavoriteMovieUseCase,
    private val removeFavoriteMovieUseCase: RemoveFavoriteMovieUseCase,
    private val isFavoriteMovieExistUseCase: IsFavoriteMovieExistUseCase
) : BaseViewModel<MovieDetailDomain, HomeViewEffects>() {

    var favoriteState: MutableLiveData<Boolean> = MutableLiveData()

    fun getMovieDetail(id: Int) = executeUseCase {
        getMovieDetailUseCase(id).onSuccess { _viewState.value = Success(it) }
            .onFailure { _viewState.value = Error(it.throwable) }
    }

    fun onFavoriteButtonClicked(movieDomain: MovieDomain) = executeUseCase {
        if (favoriteState.value == true) {
            removeFavoriteMovie(movieDomain)
        } else {
            saveFavoriteMovie(movieDomain)
        }
    }

    fun saveFavoriteMovie(movieDomain: MovieDomain) = executeUseCase {
        saveFavoriteMovieUseCase(movieDomain).onSuccess {
            favoriteState.value = true
        }.onFailure { _viewState.value = Error(it.throwable) }
    }

    fun removeFavoriteMovie(movieDomain: MovieDomain) = executeUseCase {
        removeFavoriteMovieUseCase(movieDomain).onSuccess {
            favoriteState.value = false
        }.onFailure { _viewState.value = Error(it.throwable) }
    }

    fun isFavoriteMovieExist(movieId: Int) = executeUseCase {
        isFavoriteMovieExistUseCase(movieId).onSuccess {
            favoriteState.value = it.id == movieId
        }.onFailure {
            favoriteState.value = false
            _viewState.value = Error(it.throwable)
        }
    }

}