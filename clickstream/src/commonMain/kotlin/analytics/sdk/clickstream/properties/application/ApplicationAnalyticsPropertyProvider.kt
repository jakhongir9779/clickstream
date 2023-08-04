package analytics.sdk.clickstream.properties.application

import analytics.sdk.clickstream.properties.AnalyticsPropertyProvider
import analytics.sdk.clickstream.properties.AnalyticsPropertyValue
import kotlinx.serialization.Serializable

@Serializable
class ApplicationAnalyticsPropertyProvider(
    private val values: Set<ApplicationAnalyticsProperties>,
) : AnalyticsPropertyProvider {

    override val key: String = "app_properties"

    override fun properties(): Set<AnalyticsPropertyValue> =
        values
}
