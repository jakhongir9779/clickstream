package analytics.sdk.clickstream.mappers

import analytics.sdk.clickstream.properties.PropertiesProvider


internal fun PropertiesProvider.toMapWithJsonValues(): Map<String, String> {
    val map = mutableMapOf<String, String>()

    if (appProvider.properties().isNotEmpty()) {
        map += appProvider.key to appProvider.toJsonValues()
    }

    if (userProps.properties().isNotEmpty()) {
        map += userProps.key to userProps.toJsonValues()
    }

    if (deviceProps.properties().isNotEmpty()) {
        map += deviceProps.key to deviceProps.toJsonValues()
    }

    return map
}
