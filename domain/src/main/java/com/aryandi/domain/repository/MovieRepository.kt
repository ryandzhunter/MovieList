package com.aryandi.domain.repository

import com.aryandi.domain.model.MovieDetailDomain
import com.aryandi.domain.model.MovieDomain
import com.aryandi.domain.model.Result

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version MovieRepository, v 0.1 2019-10-18 16:08 by Aryandi Putra
 */
interface MovieRepository {
    suspend fun getMovies(): Result<List<MovieDomain>>
    suspend fun getMovieDetail(id : Int) : Result<MovieDetailDomain>
}