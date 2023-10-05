package analytics.sdk.clickstream.properties.device.default

import analytics.sdk.clickstream.properties.device.DeviceAnalyticsProperties
import co.touchlab.kermit.Logger


internal class GoogleAdvertisingIdProperty(
//    private val context: Context
) : DeviceAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String? {
        try {
//            if (GoogleApiAvailabilityLight.getInstance()
//                    .isGooglePlayServicesAvailable(context) != ConnectionResult.SUCCESS
//            ) return null
//            return AdvertisingIdClient.getAdvertisingIdInfo(context).id!!
        } catch (e: Exception) {
            Logger.e(e) { "Failed to get gaid" }
            return null
        }
        return ""
    }

    internal companion object {
        const val KEY = "gaid"
    }
}
