import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class GenerateShelldepsTaskKt : DefaultTask() {
    @Input
    abstract fun getClasspath(): Property<String>

    @OutputFile
    abstract fun getShellScriptPath(): Property<File>

    @TaskAction
    fun apply() {
        val cp = getClasspath().get()
        println("Applying: cp=${getClasspath().get()}, ssp=${getShellScriptPath().get().absolutePath}")
    }
}