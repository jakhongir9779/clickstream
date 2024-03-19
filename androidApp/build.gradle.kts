import Libraries.Tests.testLibs

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "uz.uzum.mobile.analytics.sdk.android"
    compileSdk = Versions.Android.compileSdkVersion
    defaultConfig {
        applicationId = "uz.uzum.mobile.analytics.sdk.android.app"
        minSdk = Versions.Android.minSdkVersion
        targetSdk = Versions.Android.targetSdkVersion
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.ui:ui-tooling:1.4.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.compose.foundation:foundation:1.4.3")
    implementation("androidx.compose.material:material:1.4.3")
    implementation("androidx.activity:activity-compose:1.7.1")

    implementation(Libraries.AndroidX.startup)
    implementation(project(":clickstream"))
    implementation(project(":event"))
    implementation(project(":platform"))
    testLibs()
}
