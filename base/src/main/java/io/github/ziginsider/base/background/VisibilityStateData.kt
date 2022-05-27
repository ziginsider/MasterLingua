package io.github.ziginsider.base.background

import androidx.lifecycle.Observer

/**
 * Used to observe visibility [State] changes.
 */
interface VisibilityStateData {

    fun observeVisibilityStateForever(observer: Observer<State>)

    fun observeVisibilityStateForever(observer: (State) -> Unit)

    fun removeVisibilityStateObserver(observer: Observer<State>)

    /**
     * Checks if application is visible (in [FOREGROUND] or [FOREGROUND_PAUSED]).
     */
    fun isAppVisible(): Boolean

    /**
     * Checks if application is in focus (in [FOREGROUND]).
     */
    fun isAppInFocus(): Boolean

    /**
     *  Describes visibility states for the application.
     */
    enum class State {
        /**
         * Corresponds [Lifecycle.Event.ON_START].
         */
        FOREGROUND,

        /**
         * Corresponds [Lifecycle.Event.ON_PAUSED].
         */
        FOREGROUND_PAUSED,

        /**
         * Corresponds [Lifecycle.Event.ON_STOP].
         */
        BACKGROUND
    }
}
