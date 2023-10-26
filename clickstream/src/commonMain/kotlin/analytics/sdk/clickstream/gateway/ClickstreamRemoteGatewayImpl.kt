package analytics.sdk.clickstream.gateway

import analytics.sdk.clickstream.data.ClickstreamAnalyticsApi
import analytics.sdk.clickstream.data.EventResult
import analytics.sdk.database.model.EventSnapshotEntity
import co.touchlab.kermit.Logger
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonArray


internal class ClickstreamRemoteGatewayImpl(
    private val api: ClickstreamAnalyticsApi
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
        val bodyJson = mapEntityToJsonBodyString(events)
        api.sendEventsTest(bodyJson)
        events.map { EventResult.Succeed(it.id) }
    } catch (e: Exception) {
        Logger.e(e) { "Failed to send events $events" }
        events.map { EventResult.Failed(it.id) }
    }

    private fun mapEntityToJsonBodyString(events: List<EventSnapshotEntity>): String {
        val jsonObject = JsonObject(
            content = emptyMap()
        )

        val finalMap = jsonObject.toMutableMap()
        events.first().properties.forEach { (k, v) ->
            val j = JsonObject(
                content = emptyMap()
            )

            val jMap = j.toMutableMap()

            val map = Json.decodeFromString<Map<String, String>>(v)
            map.forEach { (kk, vv) ->
                jMap[kk] = JsonPrimitive(vv)
            }

            finalMap[k] = JsonObject(jMap)
        }

        val eventArray = buildJsonArray {
            events.forEach {
                add(Json.parseToJsonElement(it.event))
            }
        }

        finalMap[EVENTS_JSON_KEY] = eventArray
        return JsonObject(finalMap).toString()
    }

    private companion object {
        private const val EVENTS_JSON_KEY = "events"
    }
}

