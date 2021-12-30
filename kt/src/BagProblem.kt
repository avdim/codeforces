import org.junit.Test
import kotlin.random.Random
import kotlin.test.assertEquals

class BagProblem() {

  val randomItems = List(40) {
    Item(Random.nextDouble(), Random.nextDouble())
  }

  @Test
  fun emptyInput() {
    val result = fillBag(listOf(), 0.0)
    assertEquals(emptyList(), result)
  }

  @Test
  fun testRandom() {
    val result = fillBag(randomItems, 5.0)
    result.forEach {
      println(it)
    }
  }

  @Test
  fun testBinaryData() {
    val items = List(10) { Item(1.0, 1.0) } + List(10) { Item(1.0, 2.0) }
    val result = fillBag(items, 5.0)
    result.forEach {
      println(it)
    }
  }

  data class Item(val size: Double, val cost: Double)

  private val List<Item>.cost get() = sumOf { it.cost }

  private fun fillBag(items: List<Item>, bagSize: Double): List<Item> {
    if (items.isEmpty()) {
      return emptyList()
    }
    if (bagSize <= 0) {
      return emptyList()
    }

    val withoutFirst = items.drop(1)
    val first = items[0]

    val fillWithFirst = listOf(first) + fillBag(withoutFirst, bagSize - first.size)
    val fillWithoutFirst = fillBag(withoutFirst, bagSize)

    return if (fillWithFirst.cost > fillWithoutFirst.cost) {
      fillWithFirst
    } else {
      fillWithoutFirst
    }
  }

}

