package analytics.sdk.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual class DriverFactory {

    actual fun createDriver(): SqlDriver = NativeSqliteDriver(
        name = "clickstream.db",
        schema = Database.Schema,
    )
}
