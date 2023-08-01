package analytics.sdk.clickstream.properties.device.default

import analytics.sdk.clickstream.properties.device.DeviceAnalyticsProperties


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
//            Timber.e(Exception("Failed to get gaid", e))
            return null
        }
        return ""
    }

    internal companion object {
        const val KEY = "gaid"
    }
}
