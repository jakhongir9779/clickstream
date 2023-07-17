package analytics.sdk.clickstream.properties.device.default

import analytics.sdk.clickstream.properties.device.DeviceAnalyticsProperties
import android.os.Build

internal class ModelManufacturerProperty : DeviceAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        Build.MODEL

    internal companion object {
        const val KEY = "device_model"
    }
}
