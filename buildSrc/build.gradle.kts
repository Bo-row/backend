/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    // Support convention plugins written in Kotlin. Convention plugins are build scripts in 'src/main' that automatically become available as plugins in the main build.
    `kotlin-dsl`
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
    mavenLocal()
    mavenCentral()
}

val quarkusPluginVersion: String by project

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
    implementation("org.jetbrains.kotlin:kotlin-allopen")
    implementation("io.quarkus:io.quarkus.gradle.plugin:${quarkusPluginVersion}")
}