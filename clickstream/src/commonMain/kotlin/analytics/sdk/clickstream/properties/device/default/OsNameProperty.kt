package analytics.sdk.clickstream.properties.device.default

import analytics.sdk.clickstream.properties.device.DeviceAnalyticsProperties
import android.os.Build
import timber.log.Timber

internal class OsNameProperty : DeviceAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        try {
            Build.VERSION_CODES::class.java.fields[Build.VERSION.SDK_INT].name
        } catch (e: Exception) {
            Timber.e(Exception("failed while trying to get os name property"))
            ""
        }

    internal companion object {
        const val KEY = "os_name"
    }
}
