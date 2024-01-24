package analytics.sdk.properties.user.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.user.UserAnalyticsProperties

internal fun getDefaultUserProperties(
    dependencies: PlatformDependencies,
): Set<UserAnalyticsProperties> =
    setOf(
        OperatorNameProperty(dependencies),
        OperatorCountryCodeProperty(dependencies),
        OperatorNetworkCodeProperty(dependencies),
        DefaultInstallIdProperty(dependencies)
    )

