package com.aryandi.domain.usecase

import com.aryandi.domain.model.MovieDomain
import com.aryandi.domain.repository.FavoriteMovieRepository

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version RemoveFavoriteMovieUseCaseImpl, v 0.1 2019-10-23 13:14 by Aryandi Putra
 */
class RemoveFavoriteMovieUseCaseImpl(private val repository: FavoriteMovieRepository) :
    RemoveFavoriteMovieUseCase {

    override suspend operator fun invoke(param: MovieDomain) {
        repository.removeFavoriteMovie(param)
    }
}