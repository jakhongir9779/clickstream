package analytics.sdk.clickstream.properties.application.default

import analytics.sdk.clickstream.properties.application.ApplicationAnalyticsProperties

internal fun getDefaultAppProperties(
    appVersion: String,
    packageName: String,
): Set<ApplicationAnalyticsProperties> =
    setOf(
        SdkVersionProperty(),
        AppVersionProperty(appVersion),
        PackageNameProperty(packageName),
    )
