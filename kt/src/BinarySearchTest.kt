import org.junit.Test
import kotlin.test.assertEquals

class BinarySearchTest {

  //https://youtu.be/9Wjzf8KKvYQ?list=PLrS21S1jm43jtiCPtU2xu8v8NQcbFRVX4&t=978
  //https://elizarov.medium.com/programming-binary-search-6e999783ba5d

  @Test
  fun testFirst() {
    val result = listOf(0,1,2,3,4,5,6,7).binarySearchFirstTrue { it >= 3 }
    assertEquals(3, result)
  }

  @Test
  fun testLast() {
    val result = listOf(0,1,2,3,4,5,6,7).binarySearchLastTrue { it <= 3 }
    assertEquals(3, result)
  }

  // 0 0 0 (1) 1 1
  fun <T> List<T>.binarySearchFirstTrue(good: (T) -> Boolean): Int {
    var l = -1
    var r = size
    while (l + 1 < r) {
      val m = (l + r) ushr 1 // (l+r)/2
      if (good(get(m))) {
        r = m
      } else {
        l = m
      }
    }
    return r
  }

  // 1 1 1 (0) 0 0
  fun <T> List<T>.binarySearchLastTrue(good: (T) -> Boolean): Int {
    var l = -1
    var r = size
    while (l + 1 < r) {
      val m = (l + r) ushr 1 // (l+r)/2
      if (good(get(m))) {
        l = m
      } else {
        r = m
      }
    }
    return l
  }

}
