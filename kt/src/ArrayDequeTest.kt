import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

class ArrayDequeTest {
  @Test
  fun testArrayDeque() {
    val queue:Queue<Int> = ArrayDeque()
    queue.offer(1)
    queue.offer(2)
    val values = listOf(queue.remove(), queue.remove())
    assertEquals(listOf(1,2), values)
  }

  @Test
  fun testStack() {
    val stack:Deque<Int> = ArrayDeque()
    stack.push(1)
    stack.push(2)
    val values = listOf(stack.pop(), stack.pop())
    assertEquals(listOf(2,1), values)
  }
}
