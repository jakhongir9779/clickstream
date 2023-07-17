package analytics.sdk.clickstream.properties.user.default

import analytics.sdk.clickstream.properties.user.UserAnalyticsProperties

/**
 * Идентификатор клиента Mindbox
 */
class MindboxIdProperty(
    private val muid: String
) : UserAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        muid

    internal companion object {
        const val KEY = "mindbox_id"
    }
}
