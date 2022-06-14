package org.antoniak.shelldeps

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class GenerateShelldepsTaskKt : DefaultTask() {
    @Input
    var classpath = "";

    @OutputFile
    var outputFile: File? = null;

    @TaskAction
    fun apply() {
        println("Applying: cp=${classpath}")
        outputFile!!.writeText("OK")
    }
}