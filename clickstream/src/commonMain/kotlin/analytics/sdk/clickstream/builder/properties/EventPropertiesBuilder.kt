package analytics.sdk.clickstream.builder.properties

import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@OptIn(ExperimentalObjCName::class)
class EventPropertiesBuilder internal constructor() : ClickstreamEventProperties() {
    private val parameters = mutableMapOf<String, Any>()
    private var event = EventProperties("", JsonObject(mapOf()))

    fun parameter(key: String, @ObjCName(swiftName = "string") value: String): EventProperties {
        parameters += key to value
        event = event.copy(parameters = buildJsonObjectFromParams())
        return event
    }

    private fun buildJsonObjectFromParams() = buildJsonObject {
        parameters.forEach { param ->
            when (val value = param.value) {
                is String -> put(param.key, JsonPrimitive(value))
                is Boolean -> put(param.key, JsonPrimitive(value))
                is Double -> put(param.key, JsonPrimitive(value))
                is Int -> put(param.key, JsonPrimitive(value))
                is Long -> put(param.key, JsonPrimitive(value))
                is List<*> -> {
                    put(
                        param.key, JsonArray(value.map {
                            if (it is Number) {
                                JsonPrimitive(it)
                            } else {
                                JsonPrimitive(it as String)
                            }
                        })
                    )
                }
            }
        }
    }

    fun parameter(key: String, @ObjCName(swiftName = "bool") value: Boolean): EventProperties {
        parameters += key to value
        event = event.copy(parameters = buildJsonObjectFromParams())
        return event
    }

    fun parameter(key: String, @ObjCName(swiftName = "double") value: Double): EventProperties {
        parameters += key to value
        event = event.copy(parameters = buildJsonObjectFromParams())
        return event
    }

    fun parameter(key: String, @ObjCName(swiftName = "int32") value: Int): EventProperties {
        parameters += key to value
        event = event.copy(parameters = buildJsonObjectFromParams())
        return event
    }

    fun parameter(key: String, @ObjCName(swiftName = "int") value: Long): EventProperties {
        parameters += key to value
        event = event.copy(parameters = buildJsonObjectFromParams())
        return event
    }

    fun numberListParameter(
        key: String, @ObjCName(swiftName = "numberArray") value: List<Number>
    ): EventProperties {
        parameters += key to value
        event = event.copy(parameters = buildJsonObjectFromParams())
        return event
    }

    fun stringListParameter(
        key: String, @ObjCName(swiftName = "stringArray") value: List<String>
    ): EventProperties {
        parameters += key to value
        event = event.copy(parameters = buildJsonObjectFromParams())
        return event
    }

    fun type(type: String): EventProperties {
        event = event.copy(type = type)
        return event
    }

    @ObjCName("addIfNotNil")
    fun addIfNotNull(key: String, @ObjCName(swiftName = "string") value: String?): EventProperties {
        if (value.isNullOrEmpty()) return event
        return parameter(key, value)
    }

    @ObjCName("addIfNotNil")
    fun addIfNotNull(key: String, @ObjCName(swiftName = "int32") value: Int?): EventProperties {
        if (value == null) return event
        return parameter(key, value)
    }

    @ObjCName("addIfNotNil")
    fun addIfNotNull(key: String, @ObjCName(swiftName = "double") value: Double?): EventProperties {
        if (value == null) return event
        return parameter(key, value)
    }

    @ObjCName("addIfNotNil")
    fun addIfNotNull(key: String, @ObjCName(swiftName = "int") value: Long?): EventProperties {
        if (value == null) return event
        return parameter(key, value)
    }
}
