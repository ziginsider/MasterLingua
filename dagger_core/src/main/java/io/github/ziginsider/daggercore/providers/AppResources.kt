package io.github.ziginsider.daggercore.providers

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import androidx.annotation.ArrayRes
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.PluralsRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes

interface AppResources {

    fun getColor(@ColorRes colorId: Int): Int

    fun getColorStateList(@ColorRes colorId: Int): ColorStateList?

    fun getDimension(@DimenRes resId: Int): Float

    fun getDrawable(@DrawableRes resId: Int): Drawable?

    fun getInteger(@IntegerRes resId: Int): Int

    fun getString(@StringRes stringId: Int): String

    fun getString(@StringRes stringId: Int, vararg formatArgs: Any?): String

    fun getPlurals(@PluralsRes pluralsId: Int, quantity: Int): String

    fun getStringByName(resourceName: String): String

    fun getStringByName(resourceName: String, @StringRes defaultStringRes: Int): String

    fun getStringByName(resourceName: String, defaultString: String): String

    @StringRes
    fun getStringResIdByName(resourceName: String, @StringRes defaultValue: Int = 0): Int

    fun getStringArray(@ArrayRes stringArrayId: Int): Array<String>

    @RawRes
    fun getRawResIdByName(resourceName: String): Int
}
