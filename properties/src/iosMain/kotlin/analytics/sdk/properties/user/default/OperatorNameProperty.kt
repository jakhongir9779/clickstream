package analytics.sdk.properties.user.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.user.UserAnalyticsProperties
import platform.CoreTelephony.CTTelephonyNetworkInfo

internal actual class OperatorNameProperty actual constructor(
    private val dependencies: PlatformDependencies
) : UserAnalyticsProperties {
    override val key: String = operatorNamePropertyKey

    override fun getValue(): String? =
        CTTelephonyNetworkInfo().subscriberCellularProvider?.carrierName
}
