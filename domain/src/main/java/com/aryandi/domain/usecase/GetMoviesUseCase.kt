package com.aryandi.domain.usecase

import com.aryandi.domain.base.BaseUseCase
import com.aryandi.domain.model.MovieDomain
import com.aryandi.domain.model.Result

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version GetMoviesUseCase, v 0.1 2019-10-18 15:54 by Aryandi Putra
 */
interface GetMoviesUseCase : BaseUseCase<Any, List<MovieDomain>> {

    override suspend operator fun invoke(param: Any): Result<List<MovieDomain>>
}