package analytics.sdk.properties.device.default

import analytics.sdk.platform.AndroidDependencies
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.device.DeviceAnalyticsProperties
import co.touchlab.kermit.Logger
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailabilityLight

internal actual class GoogleAdvertisingIdProperty actual constructor(
    private val dependencies: PlatformDependencies
) : DeviceAnalyticsProperties {
    override val key: String = googleAdvertisingIdPropertyKey

    override fun getValue(): String {
        val context = (dependencies as AndroidDependencies).context
        return try {
            if (GoogleApiAvailabilityLight.getInstance()
                    .isGooglePlayServicesAvailable(context) != ConnectionResult.SUCCESS
            ) {
                ""
            } else {
                AdvertisingIdClient.getAdvertisingIdInfo(context).id ?: ""
            }
        } catch (e: Exception) {
            Logger.e(e) { "Failed to get gaid" }
            ""
        }
    }
}
