package analytics.sdk.clickstream.properties.user.default

import analytics.sdk.clickstream.properties.user.UserAnalyticsProperties

/**
 * Аннонимный идентификатор клиента в Google Firebase
 */
class FirebaseAppInstanceIdProperty(
    private val firebaseAppInstanceId: String
) : UserAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        firebaseAppInstanceId

    internal companion object {
        const val KEY = "firebase_app_instance_id"
    }
}
