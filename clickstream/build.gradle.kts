import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("maven-publish")
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Versions.Kotlin.core
    id("co.touchlab.kmmbridge") version Versions.kmmBridge
    `maven-publish`
}

version = Versions.Analytics.clickstream

kotlin {

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        publishLibraryVariants("release")
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = Artifacts.Analytics.clickstream
        }
    }

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":shared:analyticstype"))
                implementation(project(":shared:event"))
                implementation(project(":shared:platform"))
                implementation(project(":shared:database"))

                implementation(project(":shared:properties"))
                implementation(project(":shared:common"))

                implementation(Libraries.Ktor.core)
                implementation(Libraries.Ktor.json)
                implementation(Libraries.Ktor.logging)
                implementation(Libraries.Ktor.contentNegotiation)

                implementation(Libraries.Kotlin.Coroutines.core)
                implementation(Libraries.Kotlin.serializationJson)
                implementation(Libraries.Logging.kermit)

                // DI
                implementation(Libraries.Koin.core)
                implementation(Libraries.Koin.test)
            }
        }

        androidMain {
            dependencies {
                api(Libraries.AndroidX.work)
                implementation(project(":shared:platform"))
                implementation(Libraries.Firebase.messaging)
                implementation(Libraries.Ktor.Engine.okHttp)
                implementation("androidx.lifecycle:lifecycle-process:2.7.0")


                // DI
                implementation(Libraries.Koin.android)
            }
        }

        iosMain {
            dependencies {
                implementation(project(":shared:properties"))
                implementation(Libraries.Ktor.Engine.darwin)
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }

//    multiplatformSwiftPackage {
//        swiftToolsVersion(Versions.Ios.swiftToolsVersion)
//        targetPlatforms {
//            iOS { v(Versions.Ios.targetPlatformVersion) }
//        }
//        outputDirectory(File(rootDir, "/"))
//    }
}

android {
    namespace = Libraries.Analytics.group
    compileSdk = Versions.Android.compileSdkVersion
    defaultConfig {
        minSdk = Versions.Android.minSdkVersion
    }
    buildFeatures {
        buildConfig = true
    }
}

project.extensions.findByType(KotlinMultiplatformExtension::class.java)?.apply {
    targets
        .filterIsInstance<KotlinNativeTarget>()
        .flatMap { it.binaries }
        .forEach { compilationUnit -> compilationUnit.linkerOpts("-lsqlite3") }
}

addGithubPackagesRepository()

kmmbridge {
    mavenPublishArtifacts()
    spm()
}

publishing {
    publications {
        withType<MavenPublication> {
            groupId = Libraries.Analytics.group
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
