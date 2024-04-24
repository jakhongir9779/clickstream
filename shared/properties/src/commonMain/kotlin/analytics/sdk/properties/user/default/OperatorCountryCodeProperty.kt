package analytics.sdk.properties.user.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.user.UserAnalyticsProperty

/**
 * Название оператора, используемого клиентом приложения
 */
internal expect class OperatorCountryCodeProperty(
    dependencies: PlatformDependencies,
) : UserAnalyticsProperty

internal const val operatorCountryCodePropertyKey = "mcc"
