package analytics.sdk.properties.user.default

import analytics.sdk.properties.user.UserAnalyticsProperties

/**
 * Идентификатор клиента Mindbox
 */
class MindboxIdProperty(
    private val mindboxId: String
) : UserAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        mindboxId

    internal companion object {
        const val KEY = "mindbox_id"
    }
}
