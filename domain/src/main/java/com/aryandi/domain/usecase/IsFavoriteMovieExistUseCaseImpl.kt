package com.aryandi.domain.usecase

import com.aryandi.domain.model.MovieDomain
import com.aryandi.domain.repository.FavoriteMovieRepository
import com.aryandi.domain.model.Result

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version IsFavoriteMovieExistUseCaseImpl, v 0.1 2019-10-23 13:14 by Aryandi Putra
 */
class IsFavoriteMovieExistUseCaseImpl(private val repository: FavoriteMovieRepository) :
    IsFavoriteMovieExistUseCase {
    override suspend fun invoke(param: Int): Result<MovieDomain> =
        repository.isFavoriteMovieExist(param)
}