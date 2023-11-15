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
        publishLibraryVariants("release")
    }

    /*
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = Artifacts.Analytics.eventSender
        }
    }
    */

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Libraries.Analytics.event)
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
            artifactId = Artifacts.Analytics.eventSender
            version = Versions.Analytics.eventSender
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
