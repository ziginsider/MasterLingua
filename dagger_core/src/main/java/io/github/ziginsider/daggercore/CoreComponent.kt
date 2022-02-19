package io.github.ziginsider.daggercore

import android.content.ContentResolver
import android.content.Context
import android.content.res.AssetManager
import android.content.res.Resources
import io.github.ziginsider.daggercore.providers.AppFiles
import io.github.ziginsider.daggercore.providers.AppResources

/**
 * The component used for providing dependencies to other modules.
 */
interface CoreComponent {

    fun getContext(): Context

    fun getResources(): Resources

    fun getAppResources(): AppResources

    fun getContentResolver(): ContentResolver

    fun getAssetManager(): AssetManager

    fun getAppFiles(): AppFiles
}
