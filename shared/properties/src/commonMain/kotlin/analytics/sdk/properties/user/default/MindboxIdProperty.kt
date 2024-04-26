package analytics.sdk.properties.user.default

import analytics.sdk.properties.user.UserAnalyticsProperty

/**
 * Идентификатор клиента Mindbox
 */
class MindboxIdProperty(private val get: () -> String) : UserAnalyticsProperty {
    override val key: String = KEY

    override fun getValue(): String =
        get()

    internal companion object {
        const val KEY = "mindbox_id"
    }
}
