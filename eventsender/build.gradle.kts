import Libraries.Kotlin.kotlin

plugins {
    id("maven-publish")
    kotlin("multiplatform").version("1.8.21")
    id("com.android.library")
}
//
//java {
//    withSourcesJar()
//}

//publishing {
//    publications {
//        register<MavenPublication>("library") {
//            groupId = "analytics.sdk"
//            artifactId = "analyticstype"
//            version = Versions.Analytics.analyticsType
//
//            afterEvaluate {
//                from(components["java"])
//
//            }
//        }
//    }
//    repositories {
//        maven {
//            url = uri(System.getenv("NEXUS_URL") ?: getLocalProperty("nexus_url"))
//            credentials(PasswordCredentials::class) {
//                username = System.getenv("NEXUS_USER") ?: getLocalProperty("nexus_user")
//                password = System.getenv("NEXUS_PASSWORD") ?: getLocalProperty("nexus_password")
//            }
//        }
//    }
//}

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
            baseName = "eventsender"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation(project(":event"))
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
