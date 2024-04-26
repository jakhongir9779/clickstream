pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AnalyticsSdk"
include(":apps:androidApp")

include(
    ":clickstream-test",
    ":clickstream",
    ":shared",
    ":shared:common",
    ":shared:event",
    ":shared:analyticstype",
    ":shared:platform",
    ":shared:properties",
    ":shared:database",
    ":shared:settings",
)
