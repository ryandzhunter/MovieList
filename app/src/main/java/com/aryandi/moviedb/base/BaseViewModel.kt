package com.aryandi.moviedb.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aryandi.data.common.coroutines.CoroutineContextProvider
import com.aryandi.data.common.utils.Connectivity
import com.aryandi.moviedb.common.ext.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version BaseViewModel, v 0.1 2019-10-21 10:51 by Aryandi Putra
 */
abstract class BaseViewModel <T : Any, E> : ViewModel(), KoinComponent {

    protected val coroutineContext: CoroutineContextProvider by inject()
    private val connectivity: Connectivity by inject()

    protected val _viewState = MutableLiveData<ViewState<T>>()
    val viewState: LiveData<ViewState<T>>
        get() = _viewState

    protected val _viewEffects = MutableLiveData<E>()
    val viewEffects: LiveData<E>
        get() = _viewEffects

    protected fun executeUseCase(action: suspend () -> Unit, noInternetAction: () -> Unit) {
        _viewState.value = Loading()
        if (connectivity.hasNetworkAccess()) {
            launch { action() }
        } else {
            noInternetAction()
        }
    }

    protected fun executeUseCase(action: suspend () -> Unit) {
        _viewState.value = Loading()
        launch { action() }
    }
}