import java.lang.Integer.max

class Solution {
  fun maxSubArray(nums: IntArray): Int {
    if(nums.isEmpty()) {
      return 0
    }
    var current = nums[0]
    var result = current
    nums.drop(1).forEach {
      current = max(current + it, it)
      result = max(result, current)
    }
    return result
  }
}
