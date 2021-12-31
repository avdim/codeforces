class LeetCode1624LargestSubstringBetweenTwoEquals {
  class Solution {
    fun maxLengthBetweenEqualCharacters(s: String): Int {
      var result = -1
      val charToFirstIndex: MutableMap<Char, Int> = mutableMapOf()
      for (i in s.indices) {
        val char = s[i]
        val previousIndex = charToFirstIndex[char]
        if (previousIndex != null) {
          result = maxOf(result, i - previousIndex - 1)
        }
        if (previousIndex == null) {
          charToFirstIndex[char] = i
        }
      }
      return result
    }
  }
}
