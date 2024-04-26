package analytics.sdk.database

import app.cash.sqldelight.db.SqlDriver

 interface PlatformDriverFactory {

    fun createDriver(): SqlDriver
    companion object{
        const val DB_NAME = "clickstream.db"
    }
}

