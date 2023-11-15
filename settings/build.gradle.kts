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
            baseName = Artifacts.Analytics.settings
        }
    }
    */

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Libraries.settings)
            }
        }
    }
}

android {
    namespace = Libraries.Analytics.group
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}

publishing {
    publications {
        withType<MavenPublication> {
            groupId = Libraries.Analytics.group
            artifactId = Artifacts.Analytics.settings
            version = Versions.Analytics.settings
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
