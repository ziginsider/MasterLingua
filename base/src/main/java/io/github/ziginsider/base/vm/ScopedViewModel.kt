package io.github.ziginsider.base.vm

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import io.github.ziginsider.base.coroutines.AppCoroutineDispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.isActive

/**
 * [ViewModel] that implements [CoroutineScope]. All coroutines execution in the [ViewModel] scope
 * will be canceled when ViewModel will be destroyed in [ViewModel.onCleared].
 */
open class ScopedViewModel(dispatchers: AppCoroutineDispatchers) : ViewModel(), CoroutineScope {

    override val coroutineContext = SupervisorJob() + dispatchers.main

    @CallSuper
    override fun onCleared() {
        super.onCleared()
        if (isActive) {
            cancel()
        }
    }
}
