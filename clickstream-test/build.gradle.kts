plugins {
    id("maven-publish")
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Versions.Kotlin.core
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

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":shared:event"))
                implementation(project(":shared:common"))
                implementation(Libraries.Analytics.clickstream)
                implementation(project(":shared:platform"))
                implementation(Libraries.Tests.coroutines)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(Libraries.Tests.mockK)
                implementation(Libraries.Tests.junit)
                implementation(Libraries.Kotlin.serializationJson)
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

//publishing {
//    publications {
//        withType<MavenPublication> {
//            groupId = Libraries.Analytics.group
//            version = Versions.Analytics.clickstreamTest
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
