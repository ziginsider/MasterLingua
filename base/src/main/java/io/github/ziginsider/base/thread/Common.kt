package io.github.ziginsider.base.thread

import android.os.Looper

/**
 * Checks if current thread is Android Main/UI thread.
 */
inline val isMainThread get() = Looper.getMainLooper() == Looper.myLooper()
