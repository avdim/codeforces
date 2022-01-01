package leetcode

import com.sun.tools.sjavac.Log.log

fun main() {
  println(listOf(1, 2, 3, 4).groupBy { it % 2 == 0 })
  listOf(1, 2, 3).groupingBy { it % 2 }.eachCount()

  println(listOf(1, 2, 3).associateBy { "str" + it })
  println(listOf(1, 2, 3).associateWith { "str" + it })
  listOf(1,2,3).associate { it to it }

}
