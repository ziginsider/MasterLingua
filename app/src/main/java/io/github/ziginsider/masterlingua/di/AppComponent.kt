package io.github.ziginsider.masterlingua.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import io.github.ziginsider.daggercore.CoreComponent
import io.github.ziginsider.masterlingua.main.MainActivity
import io.github.ziginsider.masterlingua.main.MainApplication
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
        AppBindsModule::class,
    ]
)
@Singleton
interface AppComponent : CoreComponent {

    fun inject(mainApplication: MainApplication)
    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}
