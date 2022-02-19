package io.github.ziginsider.masterlingua.main

import android.app.Application
import android.content.Context
import android.util.Log
import io.github.ziginsider.daggercore.CoreComponent
import io.github.ziginsider.daggercore.CoreComponentProvider
import io.github.ziginsider.masterlingua.di.AppComponent
import io.github.ziginsider.masterlingua.di.DaggerAppComponent

class MainApplication : Application(), CoreComponentProvider {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        Log.i(TAG, "onCreate()")
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
    }

    override fun provideCoreComponent(): CoreComponent {
        return appComponent
    }

    private companion object {

        private const val TAG = "MainApplication"
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApplication -> this.appComponent
        else -> this.applicationContext.appComponent
    }
