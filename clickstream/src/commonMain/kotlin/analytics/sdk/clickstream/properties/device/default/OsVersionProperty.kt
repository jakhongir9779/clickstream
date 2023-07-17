package analytics.sdk.clickstream.properties.device.default

import analytics.sdk.clickstream.properties.device.DeviceAnalyticsProperties
import android.os.Build

internal class OsVersionProperty : DeviceAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        Build.VERSION.SDK_INT.toString()

    internal companion object {
        const val KEY = "os_version"
    }
}
