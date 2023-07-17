package analytics.sdk.clickstream.properties.user.default

import analytics.sdk.clickstream.properties.user.UserAnalyticsProperties

/**
 * Аннонимный идентификатор клиента Mindbox
 */
class MindboxAnonIdProperty(
    private val muid: String
) : UserAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        muid

    internal companion object {
        const val KEY = "muid"
    }
}
