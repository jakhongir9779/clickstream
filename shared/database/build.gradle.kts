plugins {
    id("maven-publish")
    kotlin("multiplatform")
    kotlin("plugin.serialization") version Versions.Kotlin.core
    id("com.android.library")
    id("app.cash.sqldelight") version Versions.sqlDelight
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain {
            dependencies {
                implementation(Libraries.Kotlin.serializationJson)
            }
        }

        androidMain {
            dependencies {
                implementation(Libraries.SqlDelight.Driver.android)
            }
        }

        iosMain {
            dependencies {
                implementation(Libraries.SqlDelight.Driver.native)
            }
        }
    }
}

addGithubPackagesRepository()
android {
    namespace = Libraries.Analytics.group
    compileSdk = Versions.Android.compileSdkVersion
    defaultConfig {
        minSdk = Versions.Android.minSdkVersion
    }
}

sqldelight {
    databases {
        create("ClickstreamDatabase") {
            packageName.set("analytics.sdk.database")
            version = 2
        }
    }
}