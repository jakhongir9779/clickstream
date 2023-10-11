plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version Versions.Kotlin.core
    id("com.android.library")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
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
            baseName = "properties"
        }
    }

    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(Libraries.Google.Services.gmsBase)
                implementation(Libraries.Google.Services.gmsAds)
            }
        }
        val commonMain by getting {
            dependencies {
                implementation(Libraries.Kotlin.serialization)
                implementation(Libraries.Logging.kermit)
                implementation(project(":platform"))
            }
        }
    }
}

android {
    namespace = "analytics.sdk.properties"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}
