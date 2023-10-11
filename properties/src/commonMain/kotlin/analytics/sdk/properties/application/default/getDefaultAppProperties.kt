package analytics.sdk.properties.application.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.application.ApplicationAnalyticsProperties

internal fun getDefaultAppProperties(
    dependencies: PlatformDependencies,
): Set<ApplicationAnalyticsProperties> =
    setOf(
        SdkVersionProperty(),
        AppVersionProperty(dependencies),
        PackageNameProperty(dependencies),
    )
