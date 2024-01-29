package analytics.sdk.platform.properties

import analytics.sdk.platform.PlatformDependencies

class EventPropertiesDelegate(
    private val dependencies: PlatformDependencies,
) : UpdateCounter {

    private var counter = 1L

    fun get(incrementCounter: Boolean): EventAdditionalProperties =
        EventAdditionalProperties(
            timeZone = dependencies.utils.getTimezone(),
            timestamp = dependencies.utils.generateTimestamp().toString(),
            counter = getCurrentCounter(incrementCounter),
        )

    fun getViewId(): ViewId {
        val generateNewViewId = dependencies.utils.generateUUID()
        return ViewId(generateNewViewId, dependencies.settings.eventProperties.lastViewId)
    }

    override fun resetCounter() {
        counter = 1
    }

    private fun getCurrentCounter(incrementCounter: Boolean): Long =
        if (incrementCounter) ++counter else counter

}
