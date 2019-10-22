package com.aryandi.data.common.coroutines

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version CoroutineContextProvider, v 0.1 2019-10-21 09:40 by Aryandi Putra
 */

open class CoroutineContextProvider {
    open val main: CoroutineContext by lazy { Dispatchers.Main }
    open val io: CoroutineContext by lazy { Dispatchers.IO }
    open val default: CoroutineContext by lazy { Dispatchers.Default }
}

class TestCoroutineContextProvider : CoroutineContextProvider() {
    override val main: CoroutineContext = Dispatchers.Unconfined
    override val io: CoroutineContext = Dispatchers.Unconfined
    override val default: CoroutineContext = Dispatchers.Unconfined
}