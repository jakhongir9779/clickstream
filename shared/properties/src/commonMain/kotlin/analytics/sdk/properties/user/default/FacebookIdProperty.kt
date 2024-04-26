package analytics.sdk.properties.user.default

import analytics.sdk.properties.user.UserAnalyticsProperty

/**
 * Аннонимный идентификатор клиента Facebook
 */
class FacebookIdProperty(private val get: () -> String) : UserAnalyticsProperty {
    override val key: String = KEY

    override fun getValue(): String = get()

    internal companion object {
        const val KEY = "facebook_anon_id"
    }
}
