package analytics.sdk.clickstream.gateway

import analytics.sdk.clickstream.data.ClickstreamAnalyticsApi
import analytics.sdk.clickstream.data.EventResult
import analytics.sdk.clickstream.data.database.entity.EventSnapshotEntity
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import timber.log.Timber

internal class ClickstreamRemoteGatewayImpl(
    private val api: ClickstreamAnalyticsApi,
) : ClickstreamRemoteGateway {

    override suspend fun send(events: List<EventSnapshotEntity>): List<EventResult> {
        val sentResults = mutableListOf<EventResult>()
        events.groupBy { it.propertyHash }.forEach {
                sentResults += sendBatchedByTheSameHash(it.value)
            }
        return sentResults
    }

    private suspend fun sendBatchedByTheSameHash(
        events: List<EventSnapshotEntity>,
    ): List<EventResult> = try {
        val body = mapEntityToJsonBodyString(events)
        val result = api.sendEvents(body)
        if (result.isSuccessful) {
            events.map { EventResult.Succeed(it.id) }
        } else {
            events.map { EventResult.Failed(it.id) }
        }
    } catch (e: Exception) {
        Timber.e(Exception(Exception("Failed to send events $events", e)))
        events.map { EventResult.Failed(it.id) }
    }

    // TODO refactor double work string <-> json <-> string
    private fun mapEntityToJsonBodyString(events: List<EventSnapshotEntity>): String {
        val jsonObject = JsonObject()

        events.first().properties.forEach { (k, v) ->
            val j = JsonObject()

            val map = gson.fromJson(v, Map::class.java)
            map.forEach { (kk, vv) ->
                check(kk is String)
                check(vv is String)
                j.addProperty(kk, vv)
            }
            jsonObject.add(k, j)
        }

        val eventArray = JsonArray(events.size)
        events.forEach {
            val fromJson = gson.fromJson(it.eventJson, JsonElement::class.java)
            eventArray.add(fromJson)
        }
        jsonObject.add(EVENTS_JSON_KEY, eventArray)


        // TODO change to production
        val body = gson.toJson(jsonObject)
        return body
    }

    private companion object {
        private const val EVENTS_JSON_KEY = "events"
        private val gson = Gson()
    }
}
