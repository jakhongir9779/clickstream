package analytics.sdk.properties

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.application.ApplicationAnalyticsProperties
import analytics.sdk.properties.application.ApplicationAnalyticsPropertyProvider
import analytics.sdk.properties.application.default.getDefaultAppProperties
import analytics.sdk.properties.device.DeviceAnalyticsProperties
import analytics.sdk.properties.device.DeviceAnalyticsPropertyProvider
import analytics.sdk.properties.device.default.getDefaultDeviceProperties
import analytics.sdk.properties.user.UserAnalyticsProperty
import analytics.sdk.properties.user.UserAnalyticsPropertyProvider
import analytics.sdk.properties.user.default.getDefaultUserProperties
import co.touchlab.kermit.Logger

@Suppress("UNCHECKED_CAST")
fun mergePropertiesWithDefault(
    dependencies: PlatformDependencies,
    propertiesProvider: PropertiesProvider?,
): PropertiesProvider {

    val defaultPropertiesProvider = PropertiesProvider(
        appProps = ApplicationAnalyticsPropertyProvider(
            getDefaultAppProperties(dependencies)
        ),
        deviceProps = DeviceAnalyticsPropertyProvider(
            getDefaultDeviceProperties(dependencies)
        ),
        userProps = UserAnalyticsPropertyProvider(
            getDefaultUserProperties(dependencies)
        ),
    )

    // should drop default in case of conflict
    val appProps = mergeProperties(
        defaultPropertiesProvider.appProps.properties(),
        propertiesProvider?.appProps?.properties(),
    )

    val userProps = mergeProperties(
        defaultPropertiesProvider.userProps.properties(),
        propertiesProvider?.userProps?.properties(),
    )

    val deviceProps = mergeProperties(
        defaultPropertiesProvider.deviceProps.properties(),
        propertiesProvider?.deviceProps?.properties(),
    )

    return PropertiesProvider(
        appProps = ApplicationAnalyticsPropertyProvider(
            appProps as Set<ApplicationAnalyticsProperties>
        ),
        userProps = UserAnalyticsPropertyProvider(
            userProps as Set<UserAnalyticsProperty>
        ),
        deviceProps = DeviceAnalyticsPropertyProvider(
            deviceProps as Set<DeviceAnalyticsProperties>
        )
    )
}


private fun mergeProperties(
    baseProperties: Set<AnalyticsPropertyValue>,
    customProperties: Set<AnalyticsPropertyValue>?
): Set<AnalyticsPropertyValue> {
    val userProps = baseProperties.toMutableSet()

    customProperties?.let { custom ->
        val keysToReplace = findConflictingKeys(userProps, custom)

        if (keysToReplace.isNotEmpty()) {
            logConflictWarning(keysToReplace)
        }

        // Remove conflicting keys from the userProps set.
        userProps.removeAll { it.key in keysToReplace }

        // Add all properties from the custom set.
        userProps.addAll(custom)
    }

    return userProps
}

private fun findConflictingKeys(
    baseProperties: Set<AnalyticsPropertyValue>,
    customProperties: Set<AnalyticsPropertyValue>
): Set<String> {
    return customProperties
        .distinctBy { it.key }
        .map { it.key }
        .intersect(baseProperties.map { it.key }.toSet())
        .toSet()
}

private fun logConflictWarning(keysToReplace: Set<String>) {
    Logger.w {
        """This user properties 
        |conflicted: ${keysToReplace.joinToString(separator = ",")}. 
        |Default keys will be replaced.""".trimMargin()
    }
}
