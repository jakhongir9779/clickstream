package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties
import android.os.Build
import co.touchlab.kermit.Logger

internal actual class OsNameProperty : DeviceAnalyticsProperties {
    override val key: String = osNamePropertyKey

    override fun getValue(): String {
        return try {
            Build.VERSION_CODES::class.java.fields[Build.VERSION.SDK_INT].name
        } catch (e: Exception) {
            Logger.e(e) { "Failed to get OS name" }
            ""
        }
    }
}
