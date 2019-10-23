package com.aryandi.domain.usecase

import com.aryandi.domain.TOP_RATED
import com.aryandi.domain.repository.MovieRepository

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version GetMovieDetailUseCase, v 0.1 2019-10-22 10:10 by Aryandi Putra
 */
class GetTopRatedMoviesUseCaseImpl(private val repository: MovieRepository) : GetTopRatedMoviesUseCase {

    override suspend operator fun invoke(param: Any) = repository.getTypeMovies(TOP_RATED)
}