package analytics.sdk.properties.device.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.device.DeviceAnalyticsProperties

/**
 * Язык интерфейса, установленный на устройстве
 */
internal expect class DeviceLocaleProperty(
    dependencies: PlatformDependencies
) : DeviceAnalyticsProperties

internal const val DEVICE_LOCALE_PROPERTY_KEY = "device_locale"
