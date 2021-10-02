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

  @Test
  fun collectionVideoSebastian() {
    val objects = listOf("🌱", "🚀", "💡", "🐧", "⚙️", "🤖", "📚")
    println(objects.chunked(3) { it.reversed() })
    // [[💡, 🚀, 🌱], [🤖, ⚙️, 🐧], [📚]]
        println(objects.windowed(4, 2, partialWindows = true))
    // [[🌱, 🚀, 💡, 🐧], [💡, 🐧, ⚙️, 🤖], [⚙️, 🤖, 📚], [📚]]
  }

  @Test
  fun listsVideoSebastian() {
    val m = mutableListOf("a", "b", "c")
    val s = m.subList(1,2)
    s[0] = "0"
    print(m)
  }

}
