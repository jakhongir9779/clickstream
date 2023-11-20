package analytics.sdk.properties.device.default

import analytics.sdk.platform.AndroidDependencies
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.device.DeviceAnalyticsProperties
import android.content.res.Resources
import android.os.Build
import co.touchlab.kermit.Logger

internal actual class DeviceLocaleProperty actual constructor(
    private val dependencies: PlatformDependencies
) : DeviceAnalyticsProperties {
    override val key: String = DEVICE_LOCALE_PROPERTY_KEY

    override fun getValue(): String {
        return try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                (dependencies as AndroidDependencies).context.resources.configuration.locales[0].toString()
            } else {
                Resources.getSystem().configuration.locale.toString()
            }
        } catch (e: Exception) {
            Logger.e(e) { "Failed to get Locale" }
            ""
        }
    }
}
