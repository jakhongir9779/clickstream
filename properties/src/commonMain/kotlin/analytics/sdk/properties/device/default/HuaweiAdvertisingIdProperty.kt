package analytics.sdk.properties.device.default

import analytics.sdk.properties.application.ApplicationAnalyticsProperties

class HuaweiAdvertisingIdProperty(
    private val huaweiAdvertisingId: String
) : ApplicationAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        huaweiAdvertisingId

    internal companion object {
        const val KEY = "oaid"
    }
}
