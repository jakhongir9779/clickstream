package analytics.sdk.database

import app.cash.sqldelight.db.SqlDriver

 interface DriverFactory {

    fun createDriver(): SqlDriver
}

