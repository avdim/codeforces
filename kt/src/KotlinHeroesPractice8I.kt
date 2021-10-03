import kotlin.math.min

fun main() {
  val (n, m) = readInts()

  val a = readInts().toMutableList()

  repeat(m) {
    val args = readInts()
    when (args.first()) {
      1 -> {
        val l = args[1]
        val r = args[2]
        val k = args[3]
        val slice = a.slice((l - 1)..(r - 1))

        class Item(val value: Int, val count: Int)

        val sortedItems = slice.groupBy { it }.map { it.value.size }.sorted()

        if (sortedItems.size < k) {
          println(-1)
        } else {
          var minDif = Int.MAX_VALUE
          val deltaK = k - 1
          for(start in 0 until sortedItems.size - deltaK) {
            minDif = min(minDif, sortedItems[start + deltaK] - sortedItems[start])
          }
          println(minDif)
        }
      }
      2 -> {
        val p = args[1]
        val x = args[2]
        a[p - 1] = x
      }
    }
  }
}

private fun readInt() = readLine()!!.toInt()
private fun readInts() = readLine()!!.split(" ").map { it.toInt() }

