fun main() {
  val (n, m) = readInts()
  val a = List(n) {
    readInts()
  }
  val b = MutableList(n) { MutableList(m) { 0 } }
  val result: MutableList<Step> = mutableListOf()
  for (i in 0..n - 2) {
    for (j in 0..m - 2) {
      if (a[i][j] == 1 && a[i + 1][j] == 1 && a[i][j + 1] == 1 && a[i + 1][j + 1] == 1) {
        result += Step(i, j)
        b[i][j] = 1
        b[i + 1][j] = 1
        b[i][j + 1] = 1
        b[i + 1][j + 1] = 1
      }
    }
  }
  if (a == b) {
    println(result.size)
    result.forEach {
      println("${it.x + 1} ${it.y + 1}")
    }
  } else {
    println("-1")
  }
}

private class Step(val x: Int, val y: Int)

private fun readInt() = readLine()!!.toInt()
private fun readInts() = readLine()!!.split(" ").map { it.toInt() }

