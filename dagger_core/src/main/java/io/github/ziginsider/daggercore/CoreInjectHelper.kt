@file:JvmName("CoreInjectHelper")

package io.github.ziginsider.daggercore

import android.content.Context

/**
 * Provides [CoreComponent] for the application.
 */
val Context.coreComponent: CoreComponent
    get() {
        val applicationContext: Context = applicationContext
        return if (applicationContext is CoreComponentProvider) {
            applicationContext.provideCoreComponent()
        } else {
            error("The application context you have passed does not implement CoreComponentProvider")
        }
    }
