plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version Versions.Kotlin.core
    id("com.android.library")
    id("app.cash.sqldelight") version Versions.sqlDelight
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
            baseName = "database"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Libraries.Kotlin.serialization)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Libraries.SqlDelight.Driver.android)
            }
        }
        val nativeMain by getting {
            dependencies {
                implementation(Libraries.SqlDelight.Driver.native)
            }
        }
    }
}

android {
    namespace = "analytics.sdk.database"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("analytics.sdk.database")
        }
    }
}
