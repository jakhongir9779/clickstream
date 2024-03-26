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
    // core
    ":common",
    ":event",
    ":analyticstype",
    //":clickstream-test",

    // composite feature
    //":clickstream",
    ":platform",
    ":properties",
    ":database",
    ":settings",
)
