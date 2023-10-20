package analytics.sdk.properties.user.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.user.UserAnalyticsProperties

class UserInstallIdProperty(
    private val dependencies: PlatformDependencies,
) : UserAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String? = with(dependencies) {
        when {
            existingInstallId.isNullOrBlank().not() -> existingInstallId
            settings.clickStream.installId.isNullOrBlank().not() -> settings.clickStream.installId
            else -> {
                settings.clickStream.installId = utils.generateUUID()
                settings.clickStream.installId
            }
        }
    }

    companion object {
        const val KEY = "install_id"
    }
}
