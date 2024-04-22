package analytics.sdk.properties.user.default

import analytics.sdk.properties.user.UserAnalyticsProperties

/**
 * Аннонимный идентификатор клиента  в Google Analytics
 */
class GoogleCidProperty(
    private val googleCid: String
) : UserAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        googleCid

    internal companion object {
        const val KEY = "google_cid"
    }
}
