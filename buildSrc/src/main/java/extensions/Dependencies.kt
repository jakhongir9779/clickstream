@file:Suppress("NOTHING_TO_INLINE")

import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import java.util.Properties

internal inline fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

internal inline fun DependencyHandler.implementation(dependency: Dependency) {
    add("implementation", dependency)
}

internal inline fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

internal inline fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

internal inline fun DependencyHandler.api(depName: String) {
    add("api", depName)
}

internal inline fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}

internal fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

internal inline fun DependencyHandler.testRuntimeOnly(depName: String) {
    add("testRuntimeOnly", depName)
}

internal inline fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}

internal inline fun DependencyHandler.androidTestRuntimeOnly(depName: String) {
    add("androidTestRuntimeOnly", depName)
}

internal inline fun DependencyHandler.debugImplementation(depName: String) {
    add("debugImplementation", depName)
}


fun Project.getLocalProperty(key: String): String {
    val localPropertiesFile = project.rootProject.file("local.properties")

    val properties = Properties()
        .takeIf { localPropertiesFile.canRead() }
        ?.also {
            it.load(localPropertiesFile.inputStream())
        } ?: error("Error while trying to load local.properties file")

    return properties.getProperty(key)
}
