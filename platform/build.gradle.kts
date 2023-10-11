plugins {
    kotlin("multiplatform")
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
            baseName = "platform"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":settings"))
                api(project(":database"))
            }
        }
    }
}

android {
    namespace = "analytics.sdk.platform"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
