package analytics.sdk.platform

import analytics.sdk.database.PlatformDriverFactory
import analytics.sdk.database.IosDriverFactory
import analytics.sdk.settings.IosSettings
import analytics.sdk.settings.PlatformSettings

class IosDependencies(
    override val appVersion: String,
    override val packageName: String,
    override val existingInstallId: String? = null,
): PlatformDependencies {

    override val databaseDriverFactory: PlatformDriverFactory = IosDriverFactory()

    override val settings: PlatformSettings = IosSettings()

    override val utils: PlatformUtils = IosUtils()
}
