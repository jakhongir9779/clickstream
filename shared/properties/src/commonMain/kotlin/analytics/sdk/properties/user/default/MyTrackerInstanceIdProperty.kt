package analytics.sdk.properties.user.default

import analytics.sdk.properties.user.UserAnalyticsProperties

/**
 * Аннонимный идентификатор клиента мобильного приложения в MyTracker
 */
class MyTrackerInstanceIdProperty(
    private val myTrackerInstanceId: String
) : UserAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        myTrackerInstanceId

    internal companion object {
        const val KEY = "my_tracker_instance_id"
    }
}
