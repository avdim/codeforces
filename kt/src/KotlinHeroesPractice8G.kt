fun main() {
  println("? " + (1..100).joinToString(" "))
  val a = readInt()
  println("? " + (1..100).map {it shl 7}.joinToString(" "))
  val b = readInt()
  val x = (a and 0b1111111_0000000) + (b and 0b1111111)
  println("! $x")
}

private fun readInt() = readLine()!!.toInt()
private fun readInts() = readLine()!!.split(" ").map { it.toInt() }
