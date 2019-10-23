package com.aryandi.domain.usecase

import com.aryandi.domain.model.MovieDetailDomain
import com.aryandi.domain.model.Result
import com.aryandi.domain.repository.MovieRepository

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version GetMovieDetailUseCase, v 0.1 2019-10-22 10:10 by Aryandi Putra
 */
class GetMovieDetailUseCaseImpl(private val repository: MovieRepository) : GetMovieDetailUseCase {
    override suspend fun invoke(param: Int): Result<MovieDetailDomain> =
        repository.getMovieDetail(param)
}