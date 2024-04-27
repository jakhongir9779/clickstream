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

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain {
            dependencies {
                implementation(Libraries.multiplatformSettings)
            }
        }
    }
}

android {
    namespace = Libraries.Analytics.group
    compileSdk = Versions.Android.compileSdkVersion
    defaultConfig {
        minSdk = Versions.Android.minSdkVersion
    }
}