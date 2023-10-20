package analytics.sdk.properties.device.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal fun getDefaultDeviceProperties(
    dependencies: PlatformDependencies,
): Set<DeviceAnalyticsProperties> =
    setOf(
        PlatformProperty(),
        ScreenResolutionProperty(dependencies),
        OsNameProperty(),
        OsVersionProperty(),
        DeviceManufacturerProperty(),
        ModelManufacturerProperty(),
        DeviceLocaleProperty(dependencies),
        AdvertisingIdProperty(dependencies),
        DeviceTypeProperty(),
        VendorIdProperty(),
    )

