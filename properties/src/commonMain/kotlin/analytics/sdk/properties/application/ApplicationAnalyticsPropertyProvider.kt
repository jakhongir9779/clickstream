package analytics.sdk.properties.application

import analytics.sdk.properties.AnalyticsPropertyProvider
import analytics.sdk.properties.AnalyticsPropertyValue
import kotlinx.serialization.Serializable

@Serializable
class ApplicationAnalyticsPropertyProvider(
    private val values: Set<ApplicationAnalyticsProperties>,
) : AnalyticsPropertyProvider {

    override val key: String = "app_properties"

    override fun properties(): Set<AnalyticsPropertyValue> =
        values
}
