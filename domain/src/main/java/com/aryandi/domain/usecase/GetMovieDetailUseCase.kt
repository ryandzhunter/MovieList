package com.aryandi.domain.usecase

import com.aryandi.domain.base.BaseUseCase
import com.aryandi.domain.model.MovieDetailDomain
import com.aryandi.domain.model.Result

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version GetMovieDetailUseCase, v 0.1 2019-10-22 10:10 by Aryandi Putra
 */
interface GetMovieDetailUseCase : BaseUseCase<Int, MovieDetailDomain> {

    override suspend operator fun invoke(param: Int): Result<MovieDetailDomain>
}