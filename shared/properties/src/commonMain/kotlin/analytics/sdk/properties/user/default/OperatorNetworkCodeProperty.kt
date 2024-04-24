package analytics.sdk.properties.user.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.user.UserAnalyticsProperty

/**
 * Мобильный код сети
 */
internal expect class OperatorNetworkCodeProperty(
    dependencies: PlatformDependencies,
) : UserAnalyticsProperty

internal const val operatorNetworkCodePropertyKey = "mnc"
