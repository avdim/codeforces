class LeetCode1624LargestSubstringBetweenTwoEquals {
  class Solution {
    fun maxLengthBetweenEqualCharacters(s: String): Int {
      var result = -1
      val charToPreviousIndex: MutableMap<Char, Int> = mutableMapOf()
      for (i in s.indices) {
        val char = s[i]
        val previousIndex = charToPreviousIndex[char]
        if(previousIndex != null) {
          result = maxOf(result, i - previousIndex - 1)
        }
        charToPreviousIndex[char] = i
      }
      return result
    }
  }
}