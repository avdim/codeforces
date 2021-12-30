import org.junit.Test
import kotlin.test.assertEquals

class MergeSort {

  @Test
  fun sortSimple() {
    val ls = listOf(1, 6, 24, 774, 22, 6, 1)

    val result = mergeSort(ls)
    println(result)
    assertEquals(ls.sorted(), result)
  }

  fun mergeSort(list: List<Int>): List<Int> {
    if (list.size <= 1) {
      return list
    }
    return merge(
      mergeSort(list.subList(0, list.size / 2)), mergeSort(list.subList(list.size / 2, list.size))
    )
  }

  private fun merge(a: List<Int>, b: List<Int>): List<Int> {
    val result: MutableList<Int> = mutableListOf()
    var i = 0
    var j = 0
    while (i < a.size && j < b.size) {
      if (a[i] < b[j]) {
        result += a[i]
        i++
      } else {
        result += b[j]
        j++
      }
    }
    if (true) {
      while (i < a.size) {
        result += a[i]
        i++
      }
      while (j < b.size) {
        result += b[j]
        j++
      }
    }
    return result + a.subList(i, a.size) + b.subList(j, b.size)
  }
}
