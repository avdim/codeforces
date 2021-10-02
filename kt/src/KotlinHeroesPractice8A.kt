fun main() {
  val t = readInt()
  repeat(t) {
    val (a, b) = readInts()
    println(a + b)
  }
}


private fun readInt() = readLine()!!.toInt()
private fun readInts() = readLine()!!.split(" ").map { it.toInt() }

