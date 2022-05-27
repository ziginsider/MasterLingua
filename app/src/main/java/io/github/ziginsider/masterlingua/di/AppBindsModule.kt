package io.github.ziginsider.masterlingua.di

import dagger.Binds
import dagger.Module
import io.github.ziginsider.base.coroutines.AppCoroutineDispatchers
import io.github.ziginsider.daggercore.providers.AppFiles
import io.github.ziginsider.daggercore.providers.AppResources
import io.github.ziginsider.masterlingua.common.AndroidAppFiles
import io.github.ziginsider.masterlingua.common.AndroidAppResources
import io.github.ziginsider.masterlingua.common.AppDispatchersImpl

@Module
interface AppBindsModule {

    @Binds
    fun bindAppResources(appResources: AndroidAppResources): AppResources

    @Binds
    fun bindAppFiles(appFiles: AndroidAppFiles): AppFiles

    @Binds
    fun bindCoroutinesDispatchers(appCoroutineDispatchers: AppDispatchersImpl): AppCoroutineDispatchers
}
