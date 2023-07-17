import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
//    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
//    implementation("com.android.tools.build:gradle:7.2.1")
//    implementation(kotlin("stdlib-jdk8"))
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "17"
}
