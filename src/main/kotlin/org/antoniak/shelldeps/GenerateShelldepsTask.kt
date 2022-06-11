import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

open class GenerateShelldepsTask : DefaultTask() {
    @Input
    var classpath: Property<String>? = null

    @OutputFile
    var shellScriptPath: Property<File>? = null

    @TaskAction
    fun apply() {
        println("runtime: ${project.configurations.named("runtime")}")
    }
}