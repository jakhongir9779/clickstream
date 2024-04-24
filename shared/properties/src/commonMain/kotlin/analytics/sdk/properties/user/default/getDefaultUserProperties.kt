package analytics.sdk.properties.user.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.user.UserAnalyticsProperty

internal fun getDefaultUserProperties(
    dependencies: PlatformDependencies,
): Set<UserAnalyticsProperty> =
    setOf(
        OperatorNameProperty(dependencies),
        OperatorCountryCodeProperty(dependencies),
        OperatorNetworkCodeProperty(dependencies),
        DefaultInstallIdProperty(dependencies)
    )

