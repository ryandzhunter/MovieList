package com.aryandi.data.repository

import com.aryandi.data.network.MovieApi
import com.aryandi.data.network.base.getData
import com.aryandi.domain.model.MovieDetailDomain
import com.aryandi.domain.model.MovieDomain
import com.aryandi.domain.model.Result
import com.aryandi.domain.repository.MovieRepository

class MovieRepositoryImpl(private val movieApi: MovieApi) :
    BaseRepository(), MovieRepository {

    override suspend fun getMovies(): Result<List<MovieDomain>> {
        return fetchApiData(apiDataProvider = {
            movieApi.getMovies().getData()
        })
    }

    override suspend fun getTypeMovies(type: String): Result<List<MovieDomain>> {
        return fetchApiData(apiDataProvider = {
            movieApi.getTypeMovies(type).getData()
        })
    }

    override suspend fun getMovieDetail(id: Int): Result<MovieDetailDomain> {
        return fetchApiData(apiDataProvider = {
            movieApi.getMovieDetails(id).getData()
        })
    }
}