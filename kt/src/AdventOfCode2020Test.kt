import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class AdventOfCode2020Test {
    @Test
    fun testCompute() {
        val map = mutableMapOf("a" to 1, "b" to 2)
        map.compute("a") { _, v -> (v ?: 0) + 1 }
        println(map)
    }

    @Test
    fun testEachLine() {
        File(".").resolve("src/AdventOfCode2020Test.kt").forEachLine {
            println(it.length)
        }

    }
}
