import Libraries.Network.Retrofit.moshi

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
                implementation(project(":database"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
//                implementation(Libraries.Network.Retrofit.core)
                implementation(Libraries.Kotlin.Coroutines.core)
                implementation(Libraries.Ktor.clientCore)
                implementation(Libraries.Ktor.clientCio)
                implementation(Libraries.Ktor.clientLogging)
                implementation(Libraries.Ktor.clientContentNegotiation)
                implementation(Libraries.Ktor.clientJson)
//                implementation(Libraries.Network.OkHttp.logging)

                implementation(Libraries.Kotlin.Coroutines.core)
//                implementation(Libraries.Kotlin.Coroutines.android)
//                implementation(Libraries.Kotlin.Coroutines.jdk)

//                implementation(Libraries.Kotlin.androidExtensionsRuntime)
//                implementation(Libraries.AndroidX.annotation)
//                implementation(Libraries.Network.Retrofit.core)
//                implementation(Libraries.Network.Retrofit.converterMoshi)
//                implementation(Libraries.Network.Retrofit.adapterCoroutines)
//                implementation(Libraries.Network.OkHttp.core)
//                implementation(Libraries.Network.OkHttp.logging)

//                implementation(Libraries.Google.Services.gmsAds)

//                implementation(Libraries.Logging.timber)
//                implementation("com.squareup.retrofit2:converter-scalars:2.1.0")
//                implementation("com.google.code.gson:gson:2.10.1")
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
