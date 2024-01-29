package analytics.sdk.database

import app.cash.sqldelight.db.SqlDriver

 interface PlatformDriverFactory {

    fun createDriver(): SqlDriver
}

