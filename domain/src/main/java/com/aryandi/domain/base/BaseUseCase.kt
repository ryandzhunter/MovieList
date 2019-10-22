package com.aryandi.domain.base

import com.aryandi.domain.model.Result

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version BaseUseCase, v 0.1 2019-10-18 16:48 by Aryandi Putra
 */
interface BaseUseCase<T : Any, R : Any> {
    suspend operator fun invoke(param: T): Result<R>
}