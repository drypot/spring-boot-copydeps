
plugins {
  id("org.springframework.boot") version "2.1.8.RELEASE" apply false
  id("io.spring.dependency-management") version "1.0.8.RELEASE"
  java
  application
}

group = "com.drypot"
version = "0.0.1-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

configurations {
  compileOnly {
    extendsFrom(configurations.annotationProcessor.get())
  }
}

repositories {
    jcenter()
}

dependencyManagement {
  imports {
    mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
  }
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  compileOnly("org.projectlombok:lombok")
  annotationProcessor("org.projectlombok:lombok")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("io.projectreactor:reactor-test")
}

application {
  mainClassName = "com.drypot.App"
}

tasks.register<Delete>("deleteDeps") {
  delete("deps")
}

tasks.register<Copy>("copyDeps") {
  dependsOn("deleteDeps")
  from(configurations.default)
  into("deps")
}
