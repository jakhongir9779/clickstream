package analytics.sdk.properties.user.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.user.UserAnalyticsProperties

interface InstallIdProperties: UserAnalyticsProperties {

    companion object {
        const val KEY = "install_id"
    }
}

internal class DefaultInstallIdProperty(
    private val dependencies: PlatformDependencies,
) : InstallIdProperties {
    override val key: String = InstallIdProperties.KEY

    override fun getValue(): String? = with(dependencies) {
        when {
            settings.clickStream.installId.isNullOrBlank().not() -> settings.clickStream.installId
            else -> {
                settings.clickStream.installId = utils.generateUUID()
                settings.clickStream.installId
            }
        }
    }
}

class InstallIdProperty(
    private val installId: String
) : InstallIdProperties {
    override val key: String = InstallIdProperties.KEY

    override fun getValue(): String =
        installId
}
