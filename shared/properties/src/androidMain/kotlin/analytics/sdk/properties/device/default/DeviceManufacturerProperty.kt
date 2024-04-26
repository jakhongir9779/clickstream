package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties
import android.os.Build

internal actual class DeviceManufacturerProperty : DeviceAnalyticsProperties {
    override val key: String = deviceManufacturerPropertyKey

    override fun getValue(): String = Build.MANUFACTURER
}
