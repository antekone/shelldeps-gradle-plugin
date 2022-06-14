package org.antoniak.shelldeps

import org.gradle.api.Plugin
import org.gradle.api.Project

class PluginMain : Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.run {
            apply("java")
        }

        target.tasks.run {
            register("shelldeps-unit-test-internal-task") {
                println("works")
            }

            register("generate-shelldeps", GenerateShelldepsTaskKt::class.java) { it ->
                it.classpath = target.configurations.named("runtimeClasspath").map { it.asPath }.get()
                it.outputFile = target.file("${target.projectDir}/shelldeps.sh")
            }

            target.tasks.findByName("classes")!!.dependsOn += "generate-shelldeps"
        }
    }
}