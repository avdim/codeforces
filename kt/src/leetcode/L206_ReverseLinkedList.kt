package leetcode

//https://leetcode.com/problems/reverse-linked-list/
class Solution {
  fun reverseList(head: ListNode?): ListNode? {
    var prev = head
    var current = head?.next
    var next = head?.next?.next
    prev?.next = null
    while (current != null) {
      current.next = prev

      prev = current
      current = next
      next = next?.next
    }
    return prev
  }
}

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}

fun main() {
  val i0 = ListNode(0)
  val i1 = ListNode(1)
  val i2 = ListNode(2)
  i0.next = i1
  i1.next = i2
  println(i0.toList())
  println(Solution().reverseList(i0).toList())
}

fun ListNode?.toList():List<Int>{
  val result = mutableListOf<Int>()
  var current = this
  while (current != null) {
    result += current.`val`
    current = current.next
  }
  return result
}
