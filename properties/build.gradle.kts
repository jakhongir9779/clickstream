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
        publishLibraryVariants("release")
    }

    /*
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = Artifacts.Analytics.properties
        }
    }
    */

    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(Libraries.Google.Services.gmsBase)
                implementation(Libraries.Google.Services.gmsAds)
            }
        }
        val commonMain by getting {
            dependencies {
                implementation(Libraries.Analytics.platform)
                implementation(Libraries.Analytics.settings)
                implementation(Libraries.Kotlin.serialization)
                implementation(Libraries.Logging.kermit)
            }
        }
    }
}

android {
    namespace = Libraries.Analytics.group
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}

publishing {
    publications {
        withType<MavenPublication> {
            groupId = Libraries.Analytics.group
            artifactId = Artifacts.Analytics.properties
            version = Versions.Analytics.properties
        }
    }
    repositories {
        maven {
            url = uri(System.getenv("NEXUS_URL") ?: getLocalProperty("nexus_url"))
            credentials(PasswordCredentials::class) {
                username = System.getenv("NEXUS_USER") ?: getLocalProperty("nexus_user")
                password = System.getenv("NEXUS_PASSWORD") ?: getLocalProperty("nexus_password")
            }
        }
    }
}
