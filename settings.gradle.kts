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


    // composite feature
    ":eventsender",
//    ":composite",

    // clickstream
    ":clickstream",
//    ":clickstream-test",
//    ":clickstream-eventsender-test",

    // testing
//    ":app",
)
