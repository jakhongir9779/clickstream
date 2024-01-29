package analytics.sdk.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

class AndroidDriverFactory(val context: Context) : PlatformDriverFactory {

    override fun createDriver(): SqlDriver = AndroidSqliteDriver(
        context = context,
        name = "clickstream.db",
        schema = Database.Schema,
    )
}
