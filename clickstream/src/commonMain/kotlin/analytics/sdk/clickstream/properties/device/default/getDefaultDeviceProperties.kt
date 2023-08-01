package analytics.sdk.clickstream.properties.device.default

import analytics.sdk.clickstream.properties.device.DeviceAnalyticsProperties

internal fun getDefaultDeviceProperties(): Set<DeviceAnalyticsProperties> =
    setOf(
        PlatformProperty(),
        ScreenResolutionProperty(),
        OsNameProperty(),
        OsVersionProperty(),
        DeviceManufacturerProperty(),
        ModelManufacturerProperty(),
        DeviceLocaleProperty(),
        GoogleAdvertisingIdProperty(),
        DeviceTypeProperty(),
    )

