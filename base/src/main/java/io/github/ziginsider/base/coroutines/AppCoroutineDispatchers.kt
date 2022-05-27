package io.github.ziginsider.base.coroutines

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Helper class to provide different [CoroutineDispatcher], it serves to replace default dispatcher in whole app.
 */
interface AppCoroutineDispatchers {

    val main: CoroutineDispatcher

    val default: CoroutineDispatcher

    val io: CoroutineDispatcher
}
