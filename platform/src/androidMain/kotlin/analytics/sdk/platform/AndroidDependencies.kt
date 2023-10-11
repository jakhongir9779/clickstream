package analytics.sdk.platform

import analytics.sdk.database.AndroidDriverFactory
import analytics.sdk.database.DriverFactory
import analytics.sdk.settings.PlatformSettings
import analytics.sdk.settings.AndroidSettings
import android.content.Context

class AndroidDependencies(
    val context: Context,
    override val appVersion: String,
    override val packageName: String,
) : PlatformDependencies {

    override val databaseDriverFactory: DriverFactory = AndroidDriverFactory(context)

    override val settings: PlatformSettings = AndroidSettings(context)

    override val utils: PlatformUtils = AndroidUtils(context)
}
