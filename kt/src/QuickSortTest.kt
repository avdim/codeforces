import org.junit.Test
import kotlin.random.Random
import kotlin.test.assertEquals

class QuickSortTest {

  @Test
  fun testRandom() {
    fun checkInRandomArray() {
      val input = Array(Random.nextInt(0, 100)) {
        Random.nextInt(0, 100)
      }
      val expected = input.toList().sorted()
      quickSort(input)
      val actual = input.toList()
      assertEquals(expected, actual)
      println(actual)
    }
    repeat(10) {
      checkInRandomArray()
    }
  }

}

fun <T : Comparable<T>> quickSort(arr: Array<T>) {
  fun split(l: Int, r: Int, x: Int): Int {
    val value = arr[x]
    var m = l + 1
    arr.swap(l, x)//Сохраняем x
    for (i in l until r) {
      if (arr[i] < value) {
        arr.swap(m, i)
        m++
      }
    }
    m--
    arr.swap(l, m)//Восстанавливаем элемент с позиции x
    return m
  }
  fun sort(l: Int, r: Int) {
    if (r - l <= 1) {
      return
    }
    val m = split(l, r, Random.nextInt(l, r))
    sort(l, m)
    sort(m+1, r)
  }
  sort(0, arr.size)
}

fun <T> Array<T>.swap(i: Int, j: Int) {
  val ai = get(i)
  val aj = get(j)
  set(i, aj)
  set(j, ai)
}
