import org.junit.Test

class BinaryHeapTest {
  @Test
  fun test1() {

  }

  class MinBinaryHeap<T : Comparable<T>>() {
    val a: MutableList<T> = mutableListOf()
    fun insert(x: T) {
      a.add(x)
      var i = a.lastIndex
      while (i.parentIndex >= 0 && a[i.parentIndex] < a[i]) {
        a.swap(i, i.parentIndex)
        i = i.parentIndex
      }
    }

    fun min(): T? {
      return a.firstOrNull()
    }

    fun remove_min() {

    }
  }

}

fun <T> MutableList<T>.swap(i: Int, j: Int) {
  val ai = get(i)
  val aj = get(j)
  set(j, ai)
  set(i, aj)
}

private val Int.leftChildIndex get() = this * 2 + 1
private val Int.rightChildIndex get() = this * 2 + 2
private val Int.parentIndex get() = (this - 1) / 2

