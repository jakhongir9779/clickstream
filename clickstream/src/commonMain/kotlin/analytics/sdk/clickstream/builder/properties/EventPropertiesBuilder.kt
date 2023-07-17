package analytics.sdk.clickstream.builder.properties

class EventPropertiesBuilder internal constructor() : ClickstreamEventProperties() {
    private val parameters = mutableMapOf<String, Any>()
    private var event = EventProperties("", emptyMap())

    fun parameter(key: String, value: String): EventProperties {
        parameters += key to value
        event = event.copy(parameters = parameters)
        return event
    }

    fun parameter(key: String, value: Boolean): EventProperties {
        parameters += key to value
        event = event.copy(parameters = parameters)
        return event
    }

    fun parameter(key: String, value: Double): EventProperties {
        parameters += key to value
        event = event.copy(parameters = parameters)
        return event
    }

    fun parameter(key: String, value: List<Int>): EventProperties {
        parameters += key to value
        event = event.copy(parameters = parameters)
        return event
    }

    fun parameter(key: String, value: Int): EventProperties {
        parameters += key to value
        event = event.copy(parameters = parameters)
        return event
    }

    fun parameter(key: String, value: Long): EventProperties {
        parameters += key to value
        event = event.copy(parameters = parameters)
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
