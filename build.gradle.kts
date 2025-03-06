plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.3"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("kapt") version "2.1.0"
}

group = "org.app"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    runtimeOnly("org.flywaydb:flyway-database-postgresql:11.3.3")

    implementation("org.postgresql:postgresql:42.7.5")

    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.mapstruct:mapstruct:1.6.3")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")

    implementation("org.mapstruct.extensions.spring:mapstruct-spring-annotations:1.1.2")

    // https://mvnrepository.com/artifact/org.mapstruct.extensions.spring/mapstruct-spring-extensions
    implementation("org.mapstruct.extensions.spring:mapstruct-spring-extensions:1.1.2")

    // https://mvnrepository.com/artifact/org.mapstruct.extensions.spring/mapstruct-spring-test-extensions
    implementation("org.mapstruct.extensions.spring:mapstruct-spring-test-extensions:1.1.2")

    implementation("org.jetbrains.kotlin.kapt:org.jetbrains.kotlin.kapt.gradle.plugin:2.1.0")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
