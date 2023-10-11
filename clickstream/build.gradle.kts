plugins {
    kotlin("multiplatform").version("1.8.21")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.8.21"
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
            baseName = "clickstream"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // put your multiplatform dependencies here
                implementation(project(":analyticstype"))
                implementation(project(":eventsender"))
                implementation(project(":common"))
                implementation(project(":event"))
                implementation(project(":platform"))
                implementation(project(":properties"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")

                implementation(Libraries.Ktor.clientCore)
                implementation(Libraries.Ktor.clientCio)
                implementation(Libraries.Ktor.clientLogging)
                implementation(Libraries.Ktor.clientContentNegotiation)
                implementation(Libraries.Ktor.clientJson)

                implementation(Libraries.Kotlin.Coroutines.core)
//              implementation(Libraries.Kotlin.Coroutines.android)
//              implementation(Libraries.Kotlin.Coroutines.jdk)

//              implementation(Libraries.Kotlin.androidExtensionsRuntime)
//              implementation(Libraries.AndroidX.annotation)
//              implementation(Libraries.Google.Services.gmsAds)

                implementation(Libraries.Logging.kermit)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "analytics.sdk"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}
