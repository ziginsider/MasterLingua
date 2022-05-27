package io.github.ziginsider.base.background

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import io.github.ziginsider.base.livedata.SingleLiveEvent

/**
 * The LiveData to provide application visibility changes.
 * Allows to subscribe on the following events:
 * move the app to background, move the app to foreground.
 */
class AppVisibilityStateLiveData : SingleLiveEvent<VisibilityStateData.State>(), VisibilityStateData {

    private var lifecycleListener: LifecycleObserver? = null

    override fun observeVisibilityStateForever(observer: Observer<VisibilityStateData.State>) {
        observeForever(observer)
    }

    override fun observeVisibilityStateForever(observer: (VisibilityStateData.State) -> Unit) {
        observeForever(observer)
    }

    override fun removeVisibilityStateObserver(observer: Observer<VisibilityStateData.State>) {
        removeObserver(observer)
    }

    override fun isAppVisible(): Boolean {
        return value?.isVisible() ?: false
    }

    override fun isAppInFocus(): Boolean {
        return value == VisibilityStateData.State.FOREGROUND
    }

    override fun onActive() {
        super.onActive()
        lifecycleListener = AppLifecycleListener().also {
            ProcessLifecycleOwner.get().lifecycle.addObserver(it)
        }
    }

    override fun onInactive() {
        super.onInactive()
        lifecycleListener?.let {
            this.lifecycleListener = null
            ProcessLifecycleOwner.get().lifecycle.removeObserver(it)
        }
    }

    internal inner class AppLifecycleListener : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun onMoveToForegroundFromResume() {
            Log.i(TAG, "app was moved to foreground (onResume)")
            value = VisibilityStateData.State.FOREGROUND
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun onMoveToForegroundFromStart() {
            Log.i(TAG, "app was moved to foreground (onStart)")
            value = VisibilityStateData.State.FOREGROUND
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        fun onMoveToForegroundPaused() {
            Log.i(TAG, "app was paused")
            value = VisibilityStateData.State.FOREGROUND_PAUSED
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun onMoveToBackground() {
            Log.i(TAG, "app was moved to background")
            value = VisibilityStateData.State.BACKGROUND
        }
    }

    companion object {
        private const val TAG = "AppVisibilityStateLD"

        @JvmStatic
        fun VisibilityStateData.State.isVisible(): Boolean {
            return this == VisibilityStateData.State.FOREGROUND ||
                this == VisibilityStateData.State.FOREGROUND_PAUSED
        }
    }
}
