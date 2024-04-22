package analytics.sdk.properties.user.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.user.UserAnalyticsProperties

/**
 * Название оператора, используемого клиентом приложения
 */
internal expect class OperatorNameProperty(
    dependencies: PlatformDependencies,
) : UserAnalyticsProperties

internal const val operatorNamePropertyKey = "operator_name"
