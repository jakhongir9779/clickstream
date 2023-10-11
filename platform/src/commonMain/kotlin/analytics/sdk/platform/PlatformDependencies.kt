package analytics.sdk.platform

import analytics.sdk.database.DriverFactory
import analytics.sdk.settings.PlatformSettings

interface PlatformDependencies {

    val appVersion: String

    val packageName: String

    val databaseDriverFactory: DriverFactory

    val settings: PlatformSettings

    val utils: PlatformUtils
}
