package analytics.sdk.clickstream.sharedpreference

import android.content.SharedPreferences
import android.net.Uri
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal inline infix fun <reified T> SharedPreferences.key(
    key: String,
): ReadWriteProperty<Any, T?> =
    preferenceProperty(
        sharedPreferences = this,
        key = key,
        defaultValue = null
    )

internal inline fun <reified T : Any?> preferenceProperty(
    sharedPreferences: SharedPreferences,
    key: String,
    defaultValue: T?,
): ReadWriteProperty<Any, T?> =
    object : ReadWriteProperty<Any, T?> {

        override fun getValue(thisRef: Any, property: KProperty<*>): T? =
            sharedPreferences
                .run {
                    when {
                        contains(key) ->
                            getterByType(
                                key,
                                defaultValue ?: defaultByType()
                            )
                        else -> null
                    }
                }

        override fun setValue(thisRef: Any, property: KProperty<*>, value: T?) =
            sharedPreferences
                .edit()
                .also {
                    when (value) {
                        null -> it.remove(key)
                        else -> it.setterByType(key, value)
                    }
                }
                .apply()

        private inline fun <reified T> defaultByType(): T =
            when (T::class) {
                Boolean::class -> false
                Long::class -> 0L
                String::class -> ""
                Uri::class -> Uri.EMPTY
                Int::class -> 0
                Float::class -> 0f
                else -> throw NotImplementedError("No default implementation for type [${T::class}].")
            } as T
    }

internal inline fun <reified T : Any?> SharedPreferences.Editor.setterByType(
    key: String,
    value: T?,
) {
    when (value) {
        is Boolean -> putBoolean(key, value)
        is String -> putString(key, value)
        is Int -> putInt(key, value)
        is Long -> putLong(key, value)
        is Float -> putFloat(key, value)
        is Uri -> putString(key, value.toString())
        null -> remove(key)
        else -> throw NotImplementedError("No setter implementation for type [${T::class}].")
    }
}

internal inline fun <reified T : Any?> SharedPreferences.getterByType(
    key: String,
    defaultValue: T?,
): T =
    when (T::class) {
        Boolean::class -> getBoolean(key, defaultValue as Boolean)
        String::class -> getString(key, defaultValue as String?)
        Int::class -> getInt(key, defaultValue as Int)
        Long::class -> getLong(key, defaultValue as Long)
        Float::class -> getFloat(key, defaultValue as Float)
        Uri::class -> Uri.parse(getString(key, (defaultValue as Uri).toString()))
        else -> throw NotImplementedError("No getter implementation for type [${T::class}].")
    } as T
