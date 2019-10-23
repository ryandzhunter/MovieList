package com.aryandi.domain.usecase

import com.aryandi.domain.repository.MovieRepository

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version GetMovieDetailUseCase, v 0.1 2019-10-22 10:10 by Aryandi Putra
 */
class GetMoviesUseCaseImpl(private val repository: MovieRepository) : GetMoviesUseCase {

    override suspend operator fun invoke(param: Any) = repository.getMovies()
}