package analytics.sdk.properties.user

import analytics.sdk.properties.AnalyticsPropertyProvider
import analytics.sdk.properties.AnalyticsPropertyValue
import kotlinx.serialization.Serializable

@Serializable
class UserAnalyticsPropertyProvider(
    private val values: Set<UserAnalyticsProperties>,
) : AnalyticsPropertyProvider {

    override val key: String = "user_properties"

    override fun properties(): Set<AnalyticsPropertyValue> =
        values
}
