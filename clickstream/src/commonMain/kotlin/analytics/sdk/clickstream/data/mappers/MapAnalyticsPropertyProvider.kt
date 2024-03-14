package analytics.sdk.clickstream.data.mappers

import analytics.sdk.properties.PropertiesProvider

internal fun PropertiesProvider.toMapWithJsonValues(): Map<String, String> {
    val map = mutableMapOf<String, String>()

    if (appProps.properties().isNotEmpty()) {
        map += appProps.key to appProps.toJsonValues()
    }

    if (userProps.properties().isNotEmpty()) {
        map += userProps.key to userProps.toJsonValues()
    }

    if (deviceProps.properties().isNotEmpty()) {
        map += deviceProps.key to deviceProps.toJsonValues()
    }

    return map
}
