package analytics.sdk.clickstream.properties.device.default

import analytics.sdk.clickstream.properties.device.DeviceAnalyticsProperties
import android.content.Context

internal class ScreenResolutionProperty(
    private val context: Context
) : DeviceAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        "${context.resources.displayMetrics.heightPixels}:${context.resources.displayMetrics.widthPixels}"

    internal companion object {
        const val KEY = "screen_resolution"
    }
}
