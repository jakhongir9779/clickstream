package analytics.sdk.properties.user.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.user.UserAnalyticsProperty
import platform.CoreTelephony.CTTelephonyNetworkInfo

internal actual class OperatorNameProperty actual constructor(
    private val dependencies: PlatformDependencies
) : UserAnalyticsProperty {
    override val key: String = operatorNamePropertyKey

    override fun getValue(): String? =
        CTTelephonyNetworkInfo().subscriberCellularProvider?.carrierName
}
