import org.junit.Test
import kotlin.random.Random
import kotlin.system.measureNanoTime
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BitSortTest {

  companion object {
    const val BLOCKS = 8
  }

  @Test
  fun testRandom() {
    fun checkInRandomArray() {
      val input = Array(1024) {
        Random.nextInt(0, 1000)
      }
      val inputCopy = input.copyOf()
      val t1 = measureNanoTime {
        quickSort(inputCopy)
      }.also {
        println("quickSort: $it")
      }
      val t2 = measureNanoTime {
        bitSort(input)
      }.also {
        println("bitSort: $it")
      }
      println("ratio: ${t1 * 100 / t2 * 0.01}")
      assertTrue(inputCopy contentDeepEquals input)
    }
    repeat(10) {
      checkInRandomArray()
    }
  }

  fun bitSort(arr: Array<Int>) {
    var blocks = BLOCKS
    fun blockSize():Int {
      val result = arr.size / blocks
      return result
    }
    fun sort(l: Int, r: Int) {
      fun split(l: Int, r: Int, x: Int): Int {
        val value = arr[x]
        arr.swap(r - 1, x)//Сохраняем x
        var m = l
        for (i in l until (r - 1)) {
          if (arr[i] < value) {
            arr.swap(m, i)
            m++
          }
        }
        arr.swap(r - 1, m)//Восстанавливаем элемент с позиции x
        return m
      }


      if (r - l <= 1) {
        return
      }
      val m = split(l, r, Random.nextInt(l, r))
      sort(l, m)
      sort(m+1, r)
    }

    fun merge(l1: Int, r1: Int, l2: Int, r2: Int) {
      val beginCopy = Array(r1 - l1) { arr[l1 + it] }
      var firstPointer = 0
      var secondPointer = l2
      var insert = l1
      while (firstPointer < beginCopy.size && secondPointer < r2) {
        val first = beginCopy[firstPointer]
        val second = arr[secondPointer]
        if (first < second) {
          arr[insert] = first
          firstPointer++
        } else {
          arr[insert] = second
          secondPointer++
        }
        insert++
      }
      while (firstPointer < beginCopy.size) {
        arr[insert] = beginCopy[firstPointer]
        firstPointer++
        insert++
      }
    }
    repeat(blocks) { i ->
      sort(i * blockSize(), (i + 1) * blockSize())
    }
    while (blocks > 1) {
      blocks /= 2
      repeat(blocks) { i ->
        val size = blockSize()
        val begin = i * size
        val middle = i * size +  size / 2
        val end = (i + 1) * size
        merge(begin, middle, middle, end)
      }
    }

  }

}
