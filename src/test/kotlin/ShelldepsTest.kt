import org.gradle.testkit.runner.GradleRunner
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.File

class ShelldepsTest {
    @TempDir lateinit var testProjectDir: File
    lateinit var settingsFile: File
    lateinit var buildFile: File

    private fun defaultSettings() {
        settingsFile.writeText("""
            rootProject.name = "testproject"
        """.trimIndent())

    }

    private fun defaultBuild() {
        buildFile.writeText("""
            tasks.register("sanity") {
                doLast {
                    println("yup works")
                }
            }
        """.trimIndent())
    }

    @BeforeEach
    fun setup() {
        settingsFile = File(testProjectDir, "settings.gradle.kts")
        buildFile = File(testProjectDir, "build.gradle.kts")
        defaultSettings()
        defaultBuild()
    }

    @Test
    fun sanity() = assertEquals(2, 2)

    @Test
    fun sanity2() {
        val result = GradleRunner.create().withProjectDir(testProjectDir).withArguments("-q", "sanity").build()
        assertEquals("yup works", result.output.trim())
    }

    @Test
    fun applyPlugin() {
        buildFile.writeText("""
            plugins {
                id("org.antoniak.shelldeps")
            }
        """.trimIndent())
        val result = GradleRunner.create().withProjectDir(testProjectDir).withArguments("-q", "sanity").build()
        println(result.output)
    }
}