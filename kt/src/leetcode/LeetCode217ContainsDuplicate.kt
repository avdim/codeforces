package leetcode

class LeetCode217ContainsDuplicate {
  class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
      val containedElements: MutableSet<Int> = mutableSetOf()
      nums.forEach {
        if (containedElements.contains(it)) {
          return true
        } else {
          containedElements.add(it)
        }
      }
      return false
    }
  }
}