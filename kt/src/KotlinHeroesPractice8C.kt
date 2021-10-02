fun main() {
  val n = readInt()
  val a = readInts()
  val order = a.withIndex().sortedByDescending { it.value }
  var shoots = 0
  for (i in order.indices) {
    val x = i
    val ai = order[i].value
    shoots += ai * x + 1
  }
  println(shoots)
  println(order.joinToString(" ") { "${it.index + 1}" })
}


private fun readInt() = readLine()!!.toInt()
private fun readInts() = readLine()!!.split(" ").map { it.toInt() }

