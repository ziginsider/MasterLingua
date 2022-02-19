package io.github.ziginsider.masterlingua.common

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.PluralsRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import io.github.ziginsider.daggercore.providers.AppResources
import javax.inject.Inject

class AndroidAppResources @Inject constructor(
    private val context: Context
) : AppResources {

    private val resources = context.resources

    override fun getString(@StringRes stringId: Int): String {
        return resources.getString(stringId)
    }

    @Suppress("SpreadOperator")
    override fun getString(@StringRes stringId: Int, vararg formatArgs: Any?): String {
        return resources.getString(stringId, *formatArgs)
    }

    @ColorInt
    override fun getColor(@ColorRes colorId: Int): Int {
        return context.getColorCompat(colorId)
    }

    override fun getColorStateList(colorId: Int): ColorStateList? {
        return context.getColorStateListCompat(colorId)
    }

    override fun getInteger(@IntegerRes resId: Int): Int {
        return resources.getInteger(resId)
    }

    override fun getStringByName(resourceName: String, @StringRes defaultStringRes: Int): String {
        val resId = getStringResIdByName(resourceName)
        return if (resId != 0) resources.getString(resId) else resources.getString(defaultStringRes)
    }

    override fun getStringByName(resourceName: String): String {
        return resources.getString(getStringResIdByName(resourceName))
    }

    override fun getStringByName(resourceName: String, defaultString: String): String {
        val resId = getStringResIdByName(resourceName)
        return if (resId != 0) resources.getString(resId) else defaultString
    }

    override fun getDimension(@DimenRes resId: Int): Float {
        return resources.getDimension(resId)
    }

    override fun getDrawable(@DrawableRes resId: Int): Drawable? {
        return ContextCompat.getDrawable(context, resId)
    }

    override fun getPlurals(@PluralsRes pluralsId: Int, quantity: Int): String {
        return resources.getQuantityString(pluralsId, quantity)
    }

    @StringRes
    override fun getStringResIdByName(resourceName: String, @StringRes defaultValue: Int): Int {
        return if (resourceName.isEmpty()) {
            defaultValue
        } else {
            val resId = resources.getIdentifier(resourceName, "string", context.packageName)
            if (resId != 0) resId else defaultValue
        }
    }

    override fun getStringArray(stringArrayId: Int): Array<String> {
        return resources.getStringArray(stringArrayId)
    }

    @RawRes
    override fun getRawResIdByName(resourceName: String): Int {
        return resources.getIdentifier(resourceName, "raw", context.packageName)
    }
}

// TODO move to base module
/**
 * Short for [ContextCompat.getColor]
 *
 * @see ContextCompat.getColor
 */
inline fun Context.getColorCompat(@ColorRes colorResId: Int): Int {
    return ContextCompat.getColor(this, colorResId)
}

/**
 * Short for [ContextCompat.getColorStateList]
 *
 * @see ContextCompat.getColorStateList
 */
inline fun Context.getColorStateListCompat(@ColorRes colorResId: Int): ColorStateList? {
    return ContextCompat.getColorStateList(this, colorResId)
}
