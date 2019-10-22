package com.aryandi.moviedb.base

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version ViewState, v 0.1 2019-10-21 10:53 by Aryandi Putra
 */
sealed class ViewState<out T : Any>
class Success<out T : Any>(val data: T) : ViewState<T>()
class Error<out T : Any>(val error: Throwable) : ViewState<T>()
class Loading<out T : Any> : ViewState<T>()
class NoInternetState<T : Any> : ViewState<T>()