package analytics.sdk.platform.properties

import analytics.sdk.platform.PlatformDependencies

class EventPropertiesDelegate(
    private val dependencies: PlatformDependencies,
) : UpdateSessionId, UpdateCounter {

    private var counter = 1L

    fun get(incrementCounter: Boolean): EventAdditionalProperties =
        EventAdditionalProperties(
            timeZone = dependencies.utils.getTimezone(),
            timestamp = getTimestamp(),
            sessionId = getSessionId(),
            counter = getCurrentCounter(incrementCounter),
        )

    fun getViewId(): ViewId {
        val generateNewViewId = dependencies.utils.generateUUID()
        return ViewId(generateNewViewId, dependencies.settings.eventPropertiesSettings.lastViewId)
    }

    override fun updateSessionId() {
        dependencies.settings.eventPropertiesSettings.sessionId = dependencies.utils.generateUUID()
    }

    override fun resetCounter() {
        counter = 1
    }

    fun getCurrentCounter(incrementCounter: Boolean): Long =
        if (incrementCounter) ++counter else counter

    fun getSessionId(): String =
        dependencies.settings.eventPropertiesSettings.sessionId ?: dependencies.utils.generateUUID()

    fun getTimestamp(): String =
        dependencies.utils.generateTimestamp().toString()

}
