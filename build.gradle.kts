plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.0.2").apply(false)
    id("com.android.library").version("8.0.2").apply(false)
    kotlin("android").version("1.8.21").apply(false)
    kotlin("multiplatform").version("1.8.21").apply(false)
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
    }

    dependencies {
        // Don't forget to update version of plugin 'org.gradle.android.cache-fix' too
        // https://github.com/gradle/android-cache-fix-gradle-plugin
//        classpath("com.android.tools.build:gradle:7.2.1")
//        classpath("com.google.gms:google-services:${Versions.googleServices}")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
//        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
//        classpath("com.google.firebase:firebase-crashlytics-gradle:${Versions.Firebase.crashlytics}")
//        classpath("com.google.firebase:firebase-appdistribution-gradle:${Versions.Firebase.appDistribution}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
//        maven {
//            url = uri(java.lang.System.getenv("NEXUS_URL") ?: getLocalProperty("nexus_url"))
//            credentials(PasswordCredentials::class) {
//                username = java.lang.System.getenv("NEXUS_USER") ?: getLocalProperty("nexus_user")
//                password = java.lang.System.getenv("NEXUS_PASSWORD") ?: getLocalProperty("nexus_password")
//            }
//        }
        mavenLocal()
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
