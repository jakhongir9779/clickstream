package analytics.sdk.properties.device

import analytics.sdk.properties.AnalyticsPropertyProvider
import analytics.sdk.properties.AnalyticsPropertyValue
import kotlinx.serialization.Serializable

@Serializable
class DeviceAnalyticsPropertyProvider(
    private val values: Set<DeviceAnalyticsProperties>,
) : AnalyticsPropertyProvider {

    override val key: String = "device_properties"

    override fun properties(): Set<AnalyticsPropertyValue> =
        values
}
