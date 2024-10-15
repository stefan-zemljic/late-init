plugins {
    kotlin("jvm") version "2.0.10"
    id("maven-publish")
    id("signing")
}

group = "ch.bytecraft"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

java {
    withJavadocJar()
    withSourcesJar()
}

signing {
    useGpgCmd()
    sign(publishing.publications)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            groupId = "ch.bytecraft"
            artifactId = "late_init"
            version = "1.0.0"
        }

        withType<MavenPublication> {
            pom {
                packaging = "jar"
                name.set("LateInit")
                description.set("LateInit variables for Kotlin that to be set only once")
                url.set("https://github.com/stefan-zemljic/late-init")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("stefan-zemljic")
                        name.set("Stefan Zemljic")
                        email.set("stefan.zemljic@protonmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/stefan-zemljic/late-init.git")
                    developerConnection.set("scm:git:ssh://github.com:stefan-zemljic/late-init.git")
                    url.set("https://github.com/stefan-zemljic/late-init")
                }
            }
        }
    }

    repositories {
        mavenLocal()
    }
}