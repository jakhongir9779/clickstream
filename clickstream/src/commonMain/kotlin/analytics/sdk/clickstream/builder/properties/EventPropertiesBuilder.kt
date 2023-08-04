package analytics.sdk.clickstream.builder.properties

import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject

class EventPropertiesBuilder internal constructor() : ClickstreamEventProperties() {
    private val parameters = mutableMapOf<String, Any>()
    private var event = EventProperties("", JsonObject(mapOf()))

    fun parameter(key: String, value: String): EventProperties {
        parameters += key to value
        event = event.copy(parameters = buildJsonObjectFromParams())
        return event
    }

    private fun buildJsonObjectFromParams() =
        buildJsonObject {
            parameters.forEach { param ->
                when (param.value) {
                    is String -> {
                        put(param.key, JsonPrimitive(param.value as String))
                    }

                    is Boolean -> {
                        put(param.key, JsonPrimitive(param.value as Boolean))
                    }

                    is Double -> {
                        put(param.key, JsonPrimitive(param.value as Double))
                    }

                    is List<*> -> {
                        put(
                            param.key,
                            JsonArray((param.value as List<*>).map { JsonPrimitive(it as Int) })
                        )
                    }

                    is Int -> {
                        put(param.key, JsonPrimitive(param.value as Int))
                    }

                    is Long -> {
                        put(param.key, JsonPrimitive(param.value as Long))
                    }
                }
            }
        }

    fun parameter(key: String, value: Boolean): EventProperties {
        parameters += key to value
        event = event.copy(parameters = buildJsonObject {
            parameters.forEach {
                put(it.key, it.value as JsonPrimitive)
            }
        })
        return event
    }

    fun parameter(key: String, value: Double): EventProperties {
        parameters += key to value
        event = event.copy(parameters = buildJsonObjectFromParams())
        return event
    }

    fun parameter(key: String, value: List<Int>): EventProperties {
        parameters += key to value
        event = event.copy(parameters = buildJsonObjectFromParams())
        return event
    }

    fun parameter(key: String, value: Int): EventProperties {
        parameters += key to value
        event = event.copy(parameters = buildJsonObjectFromParams())
        return event
    }

    fun parameter(key: String, value: Long): EventProperties {
        parameters += key to value
        event = event.copy(parameters = buildJsonObjectFromParams())
        return event
    }

    fun type(type: String): EventProperties {
        event = event.copy(type = type)
        return event
    }

    fun addIfNotNull(key: String, value: String?): EventProperties {
        if (value.isNullOrEmpty()) return event
        return parameter(key, value)
    }

    fun addIfNotNull(key: String, value: Int?): EventProperties {
        if (value == null) return event
        return parameter(key, value)
    }

    fun addIfNotNull(key: String, value: Double?): EventProperties {
        if (value == null) return event
        return parameter(key, value)
    }

    fun addIfNotNull(key: String, value: Long?): EventProperties {
        if (value == null) return event
        return parameter(key, value)
    }
}
