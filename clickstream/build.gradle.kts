import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version Versions.Kotlin.core
    id("co.touchlab.kmmbridge") version Versions.kmmBridge
    `maven-publish`
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

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            export(project(":shared:analyticstype"))
            export(project(":shared:event"))
            export(project(":shared:platform"))
            export(project(":shared:database"))
            export(project(":shared:properties"))
            export(project(":shared:common"))
            isStatic = true
        }
    }

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain {
            dependencies {
                api(project(":shared:analyticstype"))
                api(project(":shared:event"))
                api(project(":shared:platform"))
                api(project(":shared:database"))
                api(project(":shared:properties"))
                api(project(":shared:common"))

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

val isGhWorkflow = project.findProperty("IS_GH_WORKFLOW")?.toString()?.toBoolean() ?: false
if (!isGhWorkflow) {
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
}
