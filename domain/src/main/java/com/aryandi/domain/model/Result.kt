package com.aryandi.domain.model

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version Result, v 0.1 2019-10-18 16:53 by Aryandi Putra
 */
sealed class Result<out T : Any>

data class Success<out T : Any>(val data: T) : Result<T>()
data class Failure(val httpError: Error) : Result<Nothing>()

class Error(val throwable: Throwable, val errorCode: Int = 0)

inline fun <T : Any> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (this is Success) action(data)
    return this
}

inline fun <T : Any> Result<T>.onFailure(action: (Error) -> Unit) {
    if (this is Failure) action(httpError)
}

