package com.aryandi.domain.usecase

import com.aryandi.domain.model.MovieDomain
import com.aryandi.domain.repository.FavoriteMovieRepository

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version IsFavoriteMovieExistUseCaseImpl, v 0.1 2019-10-23 13:14 by Aryandi Putra
 */
class IsFavoriteMovieExistUseCaseImpl(private val repository: FavoriteMovieRepository) :
    IsFavoriteMovieExistUseCase {
    override suspend fun invoke(param: MovieDomain): MovieDomain =
        repository.isFavoriteMovieExist(param)
}