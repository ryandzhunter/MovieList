package com.aryandi.moviedb.common.ext

import android.view.View
import androidx.annotation.StringRes
import androidx.lifecycle.*
import com.aryandi.data.common.coroutines.CoroutineContextProvider
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version AndroidExtensions, v 0.1 2019-10-21 10:56 by Aryandi Putra
 */
inline fun ViewModel.launch(
    coroutineContext: CoroutineContext = CoroutineContextProvider().main,
    crossinline block: suspend CoroutineScope.() -> Unit
): Job {
    return viewModelScope.launch(coroutineContext) { block() }
}

inline fun <T> LiveData<T>.subscribe(
    owner: LifecycleOwner,
    crossinline onDataReceived: (T) -> Unit
) =
    observe(owner, Observer { onDataReceived(it) })

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun snackbar(@StringRes message: Int, rootView: View) =
    Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show()

fun snackbar(message: String, rootView: View) =
    Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show()