class Solution {
  fun countBits(n: Int): IntArray {
    val result = IntArray(n + 1)
    result[0] = 0
    for (i in 0..n) {
//      i.countOneBits()
      result[i] = result[i ushr 1] + i % 2
    }
    return result
  }

}
