package analytics.sdk.clickstream.properties.user.default

import analytics.sdk.clickstream.properties.user.UserAnalyticsProperties
import analytics.sdk.clickstream.settings.ClickStreamSettings

internal fun getDefaultUserProperties(
    //context: Context,
    clickStreamSettings: ClickStreamSettings,
    getUUID: () -> String,
    getExistingInstallId: (() -> String)? = null
): Set<UserAnalyticsProperties> =
    setOf(
        OperatorNameProperty(/*context*/),
        OperatorCountryCodeProperty(/*context*/),
        OperatorNetworkCodeProperty(/*context*/),
        UserInstallIdProperty(clickStreamSettings, getUUID, getExistingInstallId)
    )

