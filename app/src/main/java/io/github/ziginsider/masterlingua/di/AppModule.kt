package io.github.ziginsider.masterlingua.di

import android.app.Application
import android.content.ContentResolver
import android.content.Context
import android.content.res.AssetManager
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.github.ziginsider.base.background.AppVisibilityStateLiveData
import io.github.ziginsider.base.background.VisibilityStateData

@Module
class AppModule {

    @Provides
    fun provideAppContext(app: Application): Context = app.applicationContext

    @Provides
    fun provideResources(app: Application): Resources = app.resources

    @Provides
    fun provideContentResolver(app: Application): ContentResolver = app.contentResolver

    @Provides
    fun provideAssetManager(app: Application): AssetManager = app.assets

    @Provides
    @Reusable
    fun provideAppForegroundStateLiveData(): VisibilityStateData {
        return AppVisibilityStateLiveData()
    }
}
