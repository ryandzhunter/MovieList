package com.aryandi.data.datasource

import com.aryandi.data.network.MovieApi

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version MovieDataSource, v 0.1 2019-10-18 09:42 by Aryandi Putra
 */
class MovieDataSource(private val service: MovieApi) {

    suspend fun getMovies() {
        service.getMovies()
    }
}