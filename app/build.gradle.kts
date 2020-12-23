plugins {
    id("io.quarkus")
    id("org.borrow.backend.kotlin-quarkus-conventions")
    id("com.sourcemuse.mongo") version "1.0.7"
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project
val integrationTestTaskName = "integrationTest"

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation(project(":mongo"))
    implementation(project(":mongo-migration"))
    implementation("io.quarkus:quarkus-core-deployment")
    implementation("io.quarkus:quarkus-core")
    implementation("io.quarkus:quarkus-smallrye-jwt")
    implementation("io.quarkus:quarkus-container-image-jib")
}



tasks.withType<io.quarkus.gradle.tasks.QuarkusDev> {
    setSourceDir("$projectDir/src/main/kotlin")
}

val integrationTest = task<Test>(integrationTestTaskName) {
    dependsOn("startManagedMongoDb")
    useJUnitPlatform() {
        includeTags(integrationTestTaskName)
    }
}

val unitTest = task<Test>("unitTest")  {
    this.testLogging {
        this.showStandardStreams = true
    }
    useJUnitPlatform() {
        excludeTags(integrationTestTaskName)
    }
}

tasks.withType<Test> {
    this.testLogging {
        this.showStandardStreams = true
    }
    dependsOn("startManagedMongoDb")
}

buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("io.quarkus:io.quarkus.gradle.plugin:1.9.0.Final")
    }
}
