fun main() {
  val t = readInt()
  repeat(t) {
    val s = readLine()!!
    println(s.trim('0').count { it == '0' })
  }

}

private fun readInt() = readLine()!!.toInt()
private fun readInts() = readLine()!!.split(" ").map { it.toInt() }

