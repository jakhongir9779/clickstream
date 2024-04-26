package analytics.sdk.platform.properties

import analytics.sdk.platform.PlatformDependencies

class EventPropertiesDelegate(
    private val dependencies: PlatformDependencies,
) : UpdateCounter {

    private var lastViewId: String? = dependencies.settings.eventProperties.lastViewId
    private var currentViewId: String? = dependencies.settings.eventProperties.currentViewId
    private var counter = 1L

    fun get(incrementCounter: Boolean): EventAdditionalProperties =
        EventAdditionalProperties(
            timeZone = dependencies.utils.getTimezone(),
            timestamp = dependencies.utils.generateTimestamp().toString(),
            counter = getCurrentCounter(incrementCounter),
        )

    fun getViewId(): ViewId {
        lastViewId = if (lastViewId == null) {
            dependencies.utils.generateUUID()
        } else {
            currentViewId
        }
        val newCurrentViewId = dependencies.utils.generateUUID()
        currentViewId = newCurrentViewId
        return ViewId(newCurrentViewId, lastViewId)
    }

    override fun resetCounter() {
        counter = 1
    }

    private fun getCurrentCounter(incrementCounter: Boolean): Long =
        if (incrementCounter) ++counter else counter

}
