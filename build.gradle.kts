import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.5.4"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm") version "1.5.21"
  kotlin("plugin.spring") version "1.5.21"
}

group = "ru.n5g"
version = "0.1"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web:2.5.4")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.5")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0")
  runtimeOnly("com.h2database:h2:1.4.200")
  testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.4")
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    jvmTarget = "11"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
