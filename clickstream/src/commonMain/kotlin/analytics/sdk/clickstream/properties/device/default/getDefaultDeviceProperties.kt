package analytics.sdk.clickstream.properties.device.default

import analytics.sdk.clickstream.properties.device.DeviceAnalyticsProperties
import android.content.Context

internal fun getDefaultDeviceProperties(context: Context): Set<DeviceAnalyticsProperties> =
    setOf(
        PlatformProperty(),
        ScreenResolutionProperty(context),
        OsNameProperty(),
        OsVersionProperty(),
        DeviceManufacturerProperty(),
        ModelManufacturerProperty(),
        DeviceLocaleProperty(context),
        GoogleAdvertisingIdProperty(context),
        DeviceTypeProperty(),
    )

