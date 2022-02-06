package io.github.ziginsider.masterlingua.di

import dagger.Binds
import dagger.Module
import io.github.ziginsider.dagger_core.providers.AppFiles
import io.github.ziginsider.dagger_core.providers.AppResources
import io.github.ziginsider.masterlingua.common.AndroidAppFiles
import io.github.ziginsider.masterlingua.common.AndroidAppResources

@Module
interface AppBindsModule {

    @Binds
    fun bindAppResources(appResources: AndroidAppResources): AppResources

    @Binds
    fun bindAppFiles(appFiles: AndroidAppFiles): AppFiles
}