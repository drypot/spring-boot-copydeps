
plugins {
  java
  application
  id("org.springframework.boot") version "2.1.8.RELEASE"
  id("io.spring.dependency-management") version "1.0.8.RELEASE"
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
    mavenBom("org.springframework.boot:spring-boot-dependencies:2.1.8.RELEASE")
  }
}

dependencies {
  compile("org.projectlombok:lombok")
  compile("org.springframework.boot:spring-boot-starter-webflux")

  annotationProcessor("org.projectlombok:lombok")

  // This dependency is used by the application.
  implementation("com.google.guava:guava:28.0-jre")

  implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
  implementation("org.springframework.boot:spring-boot-starter-webflux")

  //testImplementation("junit:junit:4.12")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("io.projectreactor:reactor-test")

}

application {
    // Define the main class for the application
    mainClassName = "com.drypot.SpringWebfluxStudyApplication"
}
