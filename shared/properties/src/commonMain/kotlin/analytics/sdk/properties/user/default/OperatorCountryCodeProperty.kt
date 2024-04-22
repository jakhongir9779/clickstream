package analytics.sdk.properties.user.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.user.UserAnalyticsProperties

/**
 * Название оператора, используемого клиентом приложения
 */
internal expect class OperatorCountryCodeProperty(
    dependencies: PlatformDependencies,
) : UserAnalyticsProperties

internal const val operatorCountryCodePropertyKey = "mcc"
