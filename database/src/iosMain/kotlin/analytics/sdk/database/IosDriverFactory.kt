package analytics.sdk.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

class IosDriverFactory : PlatformDriverFactory {

    override fun createDriver(): SqlDriver = NativeSqliteDriver(
        name = "clickstream.db",
        schema = Database.Schema,
    )
}
