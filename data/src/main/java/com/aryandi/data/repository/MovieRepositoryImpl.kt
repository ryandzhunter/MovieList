package com.aryandi.data.repository

import com.aryandi.data.MovieData
import com.aryandi.data.network.MovieApi
import com.aryandi.data.network.base.DomainMapper
import com.aryandi.data.network.base.getData
import com.aryandi.domain.model.MovieDomain
import com.aryandi.domain.model.Result
import com.aryandi.domain.repository.MovieRepository

class MovieRepositoryImpl(private val movieApi: MovieApi) :
    BaseRepository<List<MovieData>, DomainMapper<List<MovieData>>>(), MovieRepository {

    override suspend fun getMovies(): Result<List<MovieDomain>> {
        return movieApi.getMovies().getData()
    }
}