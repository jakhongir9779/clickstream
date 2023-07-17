package analytics.sdk.clickstream.properties.device.default

import analytics.sdk.clickstream.properties.device.DeviceAnalyticsProperties
import android.content.Context
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailabilityLight
import timber.log.Timber

internal class GoogleAdvertisingIdProperty(
    private val context: Context
) : DeviceAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String? {
        try {
            if (GoogleApiAvailabilityLight.getInstance()
                    .isGooglePlayServicesAvailable(context) != ConnectionResult.SUCCESS
            ) return null
            return AdvertisingIdClient.getAdvertisingIdInfo(context).id!!
        } catch (e: Exception) {
            Timber.e(Exception("Failed to get gaid", e))
            return null
        }
    }

    internal companion object {
        const val KEY = "gaid"
    }
}
