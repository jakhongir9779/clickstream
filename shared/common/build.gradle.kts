plugins {
    id("maven-publish")
    kotlin("multiplatform")
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
            baseName = Artifacts.Analytics.common
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":shared:analyticstype"))
                implementation(project(":shared:event"))
                implementation(Libraries.Ktor.core)
                // DI
                implementation(Libraries.Koin.core)
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