package io.github.ziginsider.base.coroutines

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import io.github.ziginsider.base.thread.isMainThread
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
private class LifecycleCoroutineScope(
    lifecycle: Lifecycle,
    coroutineContext: CoroutineContext
) : CoroutineScope {

    override val coroutineContext = coroutineContext + SupervisorJob()

    init {
        if (lifecycle.currentState == Lifecycle.State.DESTROYED) {
            cancel()
        } else {
            if (isMainThread) {
                lifecycle.addObserver(CancelObserver())
            } else {
                Handler(Looper.getMainLooper()).postAtFrontOfQueue {
                    lifecycle.addObserver(CancelObserver())
                }
            }
        }
    }

    inner class CancelObserver : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy() {
            cancel()
        }
    }
}

fun LifecycleOwner.newCoroutineScope(coroutineContext: CoroutineContext = EmptyCoroutineContext): CoroutineScope {
    return lifecycle.newCoroutineScope(coroutineContext)
}

fun Lifecycle.newCoroutineScope(coroutineContext: CoroutineContext = EmptyCoroutineContext): CoroutineScope {
    return LifecycleCoroutineScope(this, coroutineContext)
}
