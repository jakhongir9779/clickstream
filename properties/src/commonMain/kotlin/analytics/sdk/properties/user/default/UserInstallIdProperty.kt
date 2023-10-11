package analytics.sdk.properties.user.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.user.UserAnalyticsProperties

class UserInstallIdProperty(
    private val dependencies: PlatformDependencies,
) : UserAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String {
        with(dependencies) {
            utils.getExistingInstallId?.let { return it() }
            return with(settings.clickStreamSettings) {
                installId ?: run { utils.generateUUID().also { installId = it } }
            }
        }
    }

    companion object {
        const val KEY = "install_id"
    }
}
