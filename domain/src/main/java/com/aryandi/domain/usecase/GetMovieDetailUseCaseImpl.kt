package com.aryandi.domain.usecase

import com.aryandi.domain.model.MovieDetailDomain
import com.aryandi.domain.model.Result
import com.aryandi.domain.repository.MovieRepository

class GetMovieDetailUseCaseImpl(private val repository: MovieRepository) : GetMovieDetailUseCase {
    override suspend fun invoke(param: Int): Result<MovieDetailDomain> =
        repository.getMovieDetail(param)
}