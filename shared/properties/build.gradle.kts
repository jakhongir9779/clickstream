plugins {
    id("maven-publish")
    kotlin("multiplatform")
    kotlin("plugin.serialization") version Versions.Kotlin.core
    id("com.android.library")
}

kotlin {

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = Artifacts.Analytics.properties
        }
    }

    sourceSets {
        androidMain {
            dependencies {
                implementation(Libraries.Google.Services.gmsBase)
                implementation(Libraries.Google.Services.gmsAds)
            }
        }

        val commonMain by getting {
            dependencies {
                implementation(project(":shared:platform"))
                implementation(project(":shared:settings"))
                implementation(Libraries.Kotlin.serializationJson)
                implementation(Libraries.Logging.kermit)
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