plugins {
    id("org.borrow.backend.kotlin-common-conventions")
}

dependencies {
    api("io.quarkus:quarkus-mongodb-panache")
    api("io.quarkus:quarkus-mongodb-client")
    api("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
}
