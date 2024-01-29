package analytics.sdk.properties.user.default

import analytics.sdk.properties.user.UserAnalyticsProperties

/**
 * Аннонимный идентификатор клиента Facebook
 */
class FacebookIdProperty(
    private val facebookId: String
) : UserAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        facebookId

    internal companion object {
        const val KEY = "facebook_anon_id"
    }
}
