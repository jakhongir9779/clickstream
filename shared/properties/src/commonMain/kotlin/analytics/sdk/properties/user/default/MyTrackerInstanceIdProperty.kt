package analytics.sdk.properties.user.default

import analytics.sdk.properties.user.UserAnalyticsProperty

/**
 * Аннонимный идентификатор клиента мобильного приложения в MyTracker
 */
class MyTrackerInstanceIdProperty(private val get: () -> String) : UserAnalyticsProperty {
    override val key: String = KEY

    override fun getValue(): String = get()

    internal companion object {
        const val KEY = "my_tracker_instance_id"
    }
}
