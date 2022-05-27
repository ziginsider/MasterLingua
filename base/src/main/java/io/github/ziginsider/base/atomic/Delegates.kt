package io.github.ziginsider.base.atomic

import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import kotlin.reflect.KProperty

operator fun AtomicBoolean.getValue(thisRef: Any, property: KProperty<*>): Boolean {
    return get()
}

operator fun AtomicBoolean.setValue(thisRef: Any, property: KProperty<*>, value: Boolean) {
    set(value)
}

operator fun AtomicInteger.getValue(thisRef: Any, property: KProperty<*>): Int {
    return get()
}

operator fun AtomicInteger.setValue(thisRef: Any, property: KProperty<*>, value: Int) {
    set(value)
}
