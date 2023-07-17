package analytics.sdk.clickstream.properties

import analytics.sdk.clickstream.sharedpreference.key
import android.content.SharedPreferences

internal class EventPropertiesDelegate internal constructor(
    sharedPreferences: SharedPreferences,
    private val generateUUID: () -> String,
    private val getTimezoneId: () -> String,
    private val generateTimestamp: () -> Long,
) : UpdateSessionId, UpdateCounter {
    private var _sessionId: String? by sharedPreferences key SESSION_ID
    private var lastViewId: String? by sharedPreferences key LAST_VIEW_ID
    private var counter = 1L

    @Synchronized
    fun get(incrementCounter: Boolean): EventAdditionalProperties =
        EventAdditionalProperties(
            timeZone = getTimezoneId(),
            timestamp = getTimestamp(),
            sessionId = getSessionId(),
            counter = getCurrentCounter(incrementCounter),
        )

    @Synchronized
    fun getViewId(): ViewId {
        val generateNewViewId = generateUUID()
        return ViewId(generateNewViewId, lastViewId)
    }

    @Synchronized
    override fun updateSessionId() {
        _sessionId = generateUUID()
    }

    @Synchronized
    override fun resetCounter() {
        counter = 1
    }

    @Synchronized
    fun getCurrentCounter(incrementCounter: Boolean): Long =
        if (incrementCounter) ++counter else counter

    @Synchronized
    fun getSessionId(): String =
        _sessionId ?: generateUUID()

    @Synchronized
    fun getTimestamp(): String =
        generateTimestamp().toString()


    internal companion object {
        const val SHARED_PREFERENCES_FILE_NAME = "event_properties"

        private const val SESSION_ID = "session_id"
        private const val LAST_VIEW_ID = "last_view_id"
    }
}
