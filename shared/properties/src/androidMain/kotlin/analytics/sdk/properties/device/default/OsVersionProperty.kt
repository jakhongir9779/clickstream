package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties
import android.os.Build

internal actual class OsVersionProperty : DeviceAnalyticsProperties {
    override val key: String = osVersionPropertyKey

    override fun getValue(): String = Build.VERSION.SDK_INT.toString()
}
