package analytics.sdk.properties.user.default

import analytics.sdk.properties.user.UserAnalyticsProperties

/**
 * Аннонимный идентификатор клиента Appsflyer
 */
class AppsflyerIdProperty(
    private val appsflyerId: String
) : UserAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        appsflyerId

    internal companion object {
        const val KEY = "appsflyer_id"
    }
}
