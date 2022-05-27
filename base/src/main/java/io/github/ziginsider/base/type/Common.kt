package io.github.ziginsider.base.type

import java.util.EnumMap
import kotlin.reflect.KClass

/**
 * Cast [value] to specified type [T] or throw [ClassCastException] with [msg].
 */
inline fun <reified T : Any> requireType(value: Any?, msg: () -> String): T {
    return value as? T ?: throw ClassCastException(msg())
}

/**
 * Cast [value] to specified type [T] or throw [ClassCastException].
 */
inline fun <reified T : Any> requireType(value: Any?): T {
    return value as? T ?: throw ClassCastException(
        "Expected value type ${T::class.java.canonicalName}. Actual is ${value?.let { it::class.java.canonicalName }}"
    )
}

/**
 * Same that call lazy [LazyThreadSafetyMode.NONE]
 *
 * @see lazy
 * @see LazyThreadSafetyMode.NONE
 */
fun <T> lazyUnsafe(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)

/**
 * Get classs loader for specified Kotlin class
 */
fun <T : Any> KClass<T>.javaClassLoader(): ClassLoader {
    return requireNotNull(this.java.classLoader)
}

/**
 * Create empty [EnumMap]
 */
inline fun <reified K : Enum<K>, V> enumMapOf(): EnumMap<K, V> {
    return EnumMap<K, V>(K::class.java)
}

/**
 * Create [EnumMap] with specified [values]
 */
inline fun <reified K : Enum<K>, V> enumMapOf(vararg values: Pair<K, V>): EnumMap<K, V> {
    return EnumMap<K, V>(K::class.java).apply { putAll(values) }
}

/**
 * Create [EnumMap] from specified [map]
 */
inline fun <reified K : Enum<K>, V> enumMapOf(map: Map<K, V>): EnumMap<K, V> {
    // Different overloads of EnumMap constrcturs will be called if map is EnumMap and for common Map
    return EnumMap(map)
}
