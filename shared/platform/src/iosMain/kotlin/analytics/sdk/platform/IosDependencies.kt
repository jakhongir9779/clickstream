package analytics.sdk.platform

import analytics.sdk.database.IosDriverFactory
import analytics.sdk.database.PlatformDriverFactory
import analytics.sdk.settings.IosSettings
import analytics.sdk.settings.PlatformSettings

class IosDependencies : PlatformDependencies {

    override val databaseDriverFactory: PlatformDriverFactory = IosDriverFactory()

    override val settings: PlatformSettings = IosSettings()

    override val utils: PlatformUtils = IosUtils()

    override val fingerprinter: Fingerprinter = IosFingerprinter()
}
