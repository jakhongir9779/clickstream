package analytics.sdk.properties.user.default

import analytics.sdk.properties.user.UserAnalyticsProperty

/**
 * Аннонимный идентификатор клиента  в Google Analytics
 */
class GoogleCidProperty(private val get: () -> String) : UserAnalyticsProperty {
    override val key: String = KEY

    override fun getValue(): String = get()

    internal companion object {
        const val KEY = "google_cid"
    }
}
