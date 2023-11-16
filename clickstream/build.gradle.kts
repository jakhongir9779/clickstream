import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

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

    /*
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = Artifacts.Analytics.clickstream
        }
    }
    */

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Libraries.Analytics.analyticsType)
                implementation(Libraries.Analytics.eventSender)
                implementation(Libraries.Analytics.event)
                implementation(Libraries.Analytics.common)
                implementation(Libraries.Analytics.platform)
                implementation(Libraries.Analytics.database)
                implementation(Libraries.Analytics.properties)

                implementation(Libraries.Ktor.clientCore)
                implementation(Libraries.Ktor.clientCio)
                implementation(Libraries.Ktor.clientLogging)
                implementation(Libraries.Ktor.clientContentNegotiation)
                implementation(Libraries.Ktor.clientJson)

                implementation(Libraries.Kotlin.Coroutines.core)
                implementation(Libraries.Kotlin.serialization)
                implementation(Libraries.Logging.kermit)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
                api(Libraries.AndroidX.work)
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

project.extensions.findByType(KotlinMultiplatformExtension::class.java)?.apply {
    targets
        .filterIsInstance<KotlinNativeTarget>()
        .flatMap { it.binaries }
        .forEach { compilationUnit -> compilationUnit.linkerOpts("-lsqlite3") }
}

publishing {
    publications {
        withType<MavenPublication> {
            groupId = Libraries.Analytics.group
            artifactId = Artifacts.Analytics.clickstream
            version = Versions.Analytics.clickstream
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
