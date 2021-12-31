import org.junit.Test

class BinaryHeapTest {
  @Test
  fun test1() {

  }

  class MinBinaryHeap<T : Comparable<T>>() {
    val a: MutableList<T> = mutableListOf()
    fun insert(x: T) {
      a.add(x)
      //sift up
      var i = a.lastIndex
      while (i.parentIndex >= 0 && a[i.parentIndex] < a[i]) {
        a.swap(i, i.parentIndex)
        i = i.parentIndex
      }
    }

    fun min(): T? {
      return a.firstOrNull()
    }

    fun removeMin(): T? {
      if (a.size == 0) {
        return null
      }
      a.swap(0, a.lastIndex)
      val result = a.removeLast()
      //sift down

      fun Int.leftChild() = a[leftChildIndex]
      fun Int.rightChild() = a[rightChildIndex]
      var i = 0
      while (true) {
        val indexOfMinChild: Int = if (i.rightChildIndex < a.size) {
          if (i.leftChild() < i.rightChild()) i.leftChildIndex else i.rightChildIndex
        } else {
          if (i.leftChildIndex < a.size) {
            i.leftChildIndex
          } else {
            break
          }
        }
        if (a[i] > a[indexOfMinChild]) {
          a.swap(i, indexOfMinChild)
          i = indexOfMinChild
        } else {
          break
        }
      }
      return result
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

