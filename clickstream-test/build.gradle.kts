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

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = Artifacts.Analytics.test
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Libraries.Analytics.common)
                implementation(Libraries.Analytics.clickstream)
                implementation(Libraries.Analytics.platform)


                implementation(Libraries.Koin.core)
                implementation(Libraries.Tests.coroutines)
                implementation(Libraries.Tests.junit)
            }
        }

        val androidMain by getting {
            dependencies {
                api(Libraries.Koin.android)
                api(Libraries.Koin.test)
                implementation(Libraries.Tests.mockK)
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

publishing {
    publications {
        withType<MavenPublication> {
            groupId = Libraries.Analytics.group
            version = Versions.Analytics.clickstreamTest
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
