import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.borrow.backend.kotlin-common-conventions")
}

dependencies {
    implementation(project(":mongo"))
}
