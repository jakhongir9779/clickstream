package analytics.sdk.properties.user.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.user.UserAnalyticsProperties

internal actual class OperatorNetworkCodeProperty actual constructor(
    private val dependencies: PlatformDependencies
) : UserAnalyticsProperties {
    override val key: String = operatorNetworkCodePropertyKey

    override fun getValue(): String = dependencies.toString()
}
