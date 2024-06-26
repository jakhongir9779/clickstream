package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties

class AppMetricaDeviceIdProperty(
    private val appMetricaDeviceId: String
) : DeviceAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String = appMetricaDeviceId

    internal companion object {
        const val KEY = "appmetrica_device_id"
    }
}
