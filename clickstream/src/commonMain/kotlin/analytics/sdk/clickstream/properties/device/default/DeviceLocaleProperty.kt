package analytics.sdk.clickstream.properties.device.default

import analytics.sdk.clickstream.properties.device.DeviceAnalyticsProperties


/**
 * Язык интерфейса, установленный на устройстве
 */
internal class DeviceLocaleProperty(
//    private val context: Context
) : DeviceAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =""
//        try {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                context.resources.configuration.locales[0].toString()
//            } else {
//                context.resources.configuration.locale.toString()
//            }
//        } catch (e: Exception) {
//            Logger.e(e) { "Failed to get Locale" }
//            ""
//        }

    internal companion object {
        const val KEY = "device_locale"
    }
}
