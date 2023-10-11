package analytics.sdk.properties

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.application.ApplicationAnalyticsProperties
import analytics.sdk.properties.application.ApplicationAnalyticsPropertyProvider
import analytics.sdk.properties.application.default.getDefaultAppProperties
import analytics.sdk.properties.device.DeviceAnalyticsProperties
import analytics.sdk.properties.device.DeviceAnalyticsPropertyProvider
import analytics.sdk.properties.device.default.getDefaultDeviceProperties
import analytics.sdk.properties.user.UserAnalyticsProperties
import analytics.sdk.properties.user.UserAnalyticsPropertyProvider
import analytics.sdk.properties.user.default.getDefaultUserProperties
import co.touchlab.kermit.Logger

@Suppress("UNCHECKED_CAST")
fun mergePropertiesWithDefault(
    dependencies: PlatformDependencies,
    propertiesProvider: PropertiesProvider?,
): PropertiesProvider {

    val defaultPropertiesProvider = PropertiesProvider(
        appProvider = ApplicationAnalyticsPropertyProvider(
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
    val appProps = defaultPropertiesProvider.appProvider.properties().apply {
        propertiesProvider?.appProvider?.let { provider ->
            val replaced = provider.properties()
                .map { it.key }
                .intersect(this.map { it.key }.toSet())
            Logger.w {
                "This app properties conflicted " +
                        "${replaced.joinToString(separator = ",") { it }}, " +
                        "default keys will be replaced"
            }
            plus(provider.properties())
        }
    }

    val userProps = defaultPropertiesProvider.userProps.properties().apply {
        propertiesProvider?.userProps?.let { provider ->
            val replaced = provider.properties()
                .map { it.key }
                .intersect(this.map { it.key }.toSet())
            Logger.w {
                "This user properties conflicted " +
                        "${replaced.joinToString(separator = ",") { it }}, " +
                        "default keys will be replaced"
            }
            plus(provider.properties())
        }
    }

    val deviceProps = defaultPropertiesProvider.deviceProps.properties().apply {
        propertiesProvider?.deviceProps?.let { provider ->
            val replaced = provider.properties()
                .map { it.key }
                .intersect(this.map { it.key }.toSet())
            Logger.w {
                "This device properties conflicted " +
                        "${replaced.joinToString(separator = ",") { it }}, " +
                        "default keys will be replaced"
            }
            plus(provider.properties())
        }
    }

    return PropertiesProvider(
        appProvider = ApplicationAnalyticsPropertyProvider(
            appProps as Set<ApplicationAnalyticsProperties>
        ),
        userProps = UserAnalyticsPropertyProvider(
            userProps as Set<UserAnalyticsProperties>
        ),
        deviceProps = DeviceAnalyticsPropertyProvider(
            deviceProps as Set<DeviceAnalyticsProperties>
        )
    )
}
