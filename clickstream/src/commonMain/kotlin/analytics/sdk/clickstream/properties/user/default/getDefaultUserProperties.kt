package analytics.sdk.clickstream.properties.user.default

import analytics.sdk.clickstream.properties.user.UserAnalyticsProperties

internal fun getDefaultUserProperties(
//    context: Context,
//    sharedPreferences: SharedPreferences,
    getUUID: () -> String,
    getExistingInstallId: (() -> String)? = null
): Set<UserAnalyticsProperties> =
    setOf(
        OperatorNameProperty(/*context*/),
        OperatorCountryCodeProperty(/*context*/),
        OperatorNetworkCodeProperty(/*context*/),
        UserInstallIdProperty(/*sharedPreferences,*/ getUUID, getExistingInstallId)
    )

