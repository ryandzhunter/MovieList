package com.aryandi.domain.usecase

import com.aryandi.domain.POPULAR
import com.aryandi.domain.repository.MovieRepository

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version GetMovieDetailUseCase, v 0.1 2019-10-22 10:10 by Aryandi Putra
 */
class GetPopularMoviesUseCaseImpl(private val repository: MovieRepository) : GetPopularMoviesUseCase {

    override suspend operator fun invoke(param: Any) = repository.getTypeMovies(POPULAR)
}