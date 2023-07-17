package analytics.sdk.clickstream.properties.user

import analytics.sdk.clickstream.properties.AnalyticsPropertyProvider
import analytics.sdk.clickstream.properties.AnalyticsPropertyValue

class UserAnalyticsPropertyProvider(
    private val values: Set<UserAnalyticsProperties>,
) : AnalyticsPropertyProvider {

    override val key: String = "user_properties"

    override fun properties(): Set<AnalyticsPropertyValue> =
        values
}
