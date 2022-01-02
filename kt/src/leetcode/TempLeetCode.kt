class NumArray(nums: IntArray) {
  val prefixSum: List<Int> = nums.toList().runningReduce2 { sum, x -> sum + x }

  fun sumRange(left: Int, right: Int): Int {
    return prefixSum[right] - (prefixSum.getOrNull(left - 1) ?: 0)
  }

}

fun <T> List<T>.runningReduce2(operation: (acc: T, next: T) -> T):List<T> {
  val iterator = this.iterator()
  if (!iterator.hasNext()) return emptyList<T>()
  var accumulator: T = iterator.next()
  val result = ArrayList<T>(size).apply { add(accumulator) }
  while (iterator.hasNext()) {
    accumulator = operation(accumulator, iterator.next())
    result.add(accumulator)
  }
  return result
}
