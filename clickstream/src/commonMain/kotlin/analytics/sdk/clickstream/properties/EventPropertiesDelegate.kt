package analytics.sdk.clickstream.properties

import analytics.sdk.clickstream.settings.EventPropertiesSettings

internal class EventPropertiesDelegate internal constructor(
    private val eventPropertiesSettings: EventPropertiesSettings,
    private val generateUUID: () -> String,
    private val getTimezoneId: () -> String,
    private val generateTimestamp: () -> Long,
) : UpdateSessionId, UpdateCounter {

    private var counter = 1L

    @Synchronized
    fun get(incrementCounter: Boolean): EventAdditionalProperties =
        EventAdditionalProperties(
            timeZone = getTimezoneId(),
            timestamp = getTimestamp(),
            sessionId = getSessionId(),
            counter = getCurrentCounter(incrementCounter),
        )

    @Synchronized
    fun getViewId(): ViewId {
        val generateNewViewId = generateUUID()
        return ViewId(generateNewViewId, eventPropertiesSettings.lastViewId)
    }

    @Synchronized
    override fun updateSessionId() {
        eventPropertiesSettings.sessionId = generateUUID()
    }

    @Synchronized
    override fun resetCounter() {
        counter = 1
    }

    @Synchronized
    fun getCurrentCounter(incrementCounter: Boolean): Long =
        if (incrementCounter) ++counter else counter

    @Synchronized
    fun getSessionId(): String = eventPropertiesSettings.sessionId ?: generateUUID()

    @Synchronized
    fun getTimestamp(): String =
        generateTimestamp().toString()

}
