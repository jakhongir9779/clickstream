plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application") version "8.1.3" apply false
    id("com.android.library") version "8.1.3" apply false
    kotlin("android") version Versions.Kotlin.core apply false
    kotlin("multiplatform") version Versions.Kotlin.core apply false
    id("com.google.gms.google-services") version "4.4.1" apply false
    id("org.gradle.maven-publish")
    id("co.touchlab.kmmbridge") version Versions.kmmBridge apply false
}

val autoVersion = project.property(
    if (project.hasProperty("AUTO_VERSION")) {
        "AUTO_VERSION"
    } else {
        "LIBRARY_VERSION"
    }
) as String

subprojects {
    val GROUP: String by project
    group = GROUP
    version = autoVersion
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
        gradlePluginPortal()
        maven {
            name = "clickstream"
            url = uri("https://maven.pkg.github.com/jakhongir9779/clickstream")
            credentials {
                username = "jakhongir9779"
                password = "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"
            }
        }
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

fun getLocalProperty(key: String): String {
    val localPropertiesFile = project.rootProject.file("local.properties")

    val properties = java.util.Properties()
        .takeIf { localPropertiesFile.canRead() }
        ?.also {
            it.load(localPropertiesFile.inputStream())
        } ?: error("Error while trying to load local.properties file")

    return properties.getProperty(key)
}
