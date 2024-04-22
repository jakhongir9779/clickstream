package analytics.sdk.platform

import analytics.sdk.database.PlatformDriverFactory
import analytics.sdk.settings.PlatformSettings

interface PlatformDependencies {

    val databaseDriverFactory: PlatformDriverFactory

    val settings: PlatformSettings

    val utils: PlatformUtils

    val fingerprinter: Fingerprinter
}
