package analytics.sdk.platform

import analytics.sdk.database.AndroidDriverFactory
import analytics.sdk.database.PlatformDriverFactory
import analytics.sdk.settings.AndroidSettings
import analytics.sdk.settings.PlatformSettings
import android.content.Context

class AndroidDependencies(val context: Context) : PlatformDependencies {

    override val databaseDriverFactory: PlatformDriverFactory = AndroidDriverFactory(context)

    override val settings: PlatformSettings = AndroidSettings(context)

    override val utils: PlatformUtils = AndroidUtils(context)

    override val fingerprinter: Fingerprinter = AndroidFingerprinter(context)
}
