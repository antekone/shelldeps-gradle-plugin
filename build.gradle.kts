plugins {
    kotlin("jvm") version "1.7.0"
    `java-gradle-plugin`
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(gradleTestKit())
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")

}

tasks.withType<Test>().configureEach {
    testLogging.showStandardStreams = true
    useJUnitPlatform()
}

gradlePlugin {
    plugins {
        create("org.antoniak.shelldeps") {
            id = "org.antoniak.shelldeps"
            implementationClass = "org.antoniak.shelldeps.PluginMain"
        }
    }
}