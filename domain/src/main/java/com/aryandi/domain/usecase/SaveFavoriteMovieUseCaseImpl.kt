package com.aryandi.domain.usecase

import com.aryandi.domain.model.MovieDomain
import com.aryandi.domain.model.Result
import com.aryandi.domain.repository.FavoriteMovieRepository

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version SaveFavoriteMovieUseCase, v 0.1 2019-10-23 13:14 by Aryandi Putra
 */
class SaveFavoriteMovieUseCaseImpl(private val repository: FavoriteMovieRepository) :
    SaveFavoriteMovieUseCase {

    override suspend operator fun invoke(param: MovieDomain): Result<Long> =
        repository.insertFavoriteMovie(param)
}