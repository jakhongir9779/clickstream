package analytics.sdk.properties.user.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.user.UserAnalyticsProperties

/**
 * Мобильный код сети
 */
internal expect class OperatorNetworkCodeProperty(
    dependencies: PlatformDependencies,
) : UserAnalyticsProperties

internal const val operatorNetworkCodePropertyKey = "mnc"
