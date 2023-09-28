package analytics.sdk.clickstream.properties.device.default

import analytics.sdk.clickstream.properties.device.DeviceAnalyticsProperties


internal class OsNameProperty : DeviceAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =""
//        try {
//            Build.VERSION_CODES::class.java.fields[Build.VERSION.SDK_INT].name
//        } catch (e: Exception) {
////            Logger.e(e) { "Failed while trying to get OS name property" }
//            ""
//        }

    internal companion object {
        const val KEY = "os_name"
    }
}
