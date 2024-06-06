plugins {
    kotlin("jvm")
    id("nu.studer.jooq") version "9.0"
}

group = "com.sight"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jooq:jooq-codegen:3.19.8")
    runtimeOnly("com.mysql:mysql-connector-j:8.0.35")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}