package com.aryandi.domain.usecase

import com.aryandi.domain.model.MovieDomain

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version RemoveFavoriteMovieUseCase, v 0.1 2019-10-23 13:14 by Aryandi Putra
 */
interface RemoveFavoriteMovieUseCase {

    suspend operator fun invoke(param : MovieDomain)

}