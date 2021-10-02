fun main() {
  var a = readInt()
  val results = mutableSetOf<Int>()
  while (true) {
    results.add(a)
    a = f(a)
    if (results.contains(a)) {
      break
    }
  }
  println(results.size)
}

private fun f(x: Int): Int {
  if (x < 0) {
    throw Error("x < 0")
  }
  var result = x + 1
  while (result % 10 == 0) {
    result /= 10
  }
  return result
}

private fun readInt() = readLine()!!.toInt()
private fun readInts() = readLine()!!.split(" ").map { it.toInt() }

