package com.aryandi.domain.usecase

import com.aryandi.domain.repository.MovieRepository

class GetMoviesUseCaseImpl(private val repository: MovieRepository) : GetMoviesUseCase {

    override suspend operator fun invoke(param: Any) = repository.getMovies()
}