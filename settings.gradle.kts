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
include(":androidApp")

include(
    ":common",
    ":event",
    ":analyticstype",
    ":clickstream-test",

    ":clickstream",
    ":platform",
    ":properties",
    ":database",
    ":settings",
)
