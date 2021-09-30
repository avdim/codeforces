import org.junit.Test
import kotlin.random.Random
import kotlin.test.assertEquals

class KotlinStdLibTest {
    @Test
    fun test1() {
        val strings: List<String> = listOf(1, "two").filterIsInstance<String>()
        val (even, odd) = listOf(1, 2, 3, 4).partition { it % 2 == 0 }
    }

    @Test
    fun testGenerateSequence() {
        val ls = generateSequence {
            Random.nextInt(100).takeIf { it > 30 }
        }.toList()
        println(ls)
    }

}
