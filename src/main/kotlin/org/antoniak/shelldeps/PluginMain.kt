package org.antoniak.shelldeps

import GenerateShelldepsTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class PluginMain : Plugin<Project> {
    override fun apply(target: Project) {
        val internalTask = target.tasks.register("shelldeps-unit-test-internal-task")
        internalTask.configure { println("works") }

        val generateTask = target.tasks.register("generate-shelldeps", GenerateShelldepsTask::class.java)
    }
}