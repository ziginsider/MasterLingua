package io.github.ziginsider.masterlingua.common

import io.github.ziginsider.base.coroutines.AppCoroutineDispatchers
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * Default implementation of [AppCoroutineDispatchers].
 */
class AppDispatchersImpl @Inject constructor() : AppCoroutineDispatchers {

    override val main = Dispatchers.Main.immediate

    override val default = Dispatchers.Default

    override val io = Dispatchers.IO
}
