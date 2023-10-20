package analytics.sdk.platform

import analytics.sdk.database.PlatformDriverFactory
import analytics.sdk.settings.PlatformSettings

interface PlatformDependencies {

    val appVersion: String

    val packageName: String

    val existingInstallId: String?

    val databaseDriverFactory: PlatformDriverFactory

    val settings: PlatformSettings

    val utils: PlatformUtils
}
