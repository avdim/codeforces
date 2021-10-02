import org.junit.Test
import java.util.*

//https://github.com/Arhiser/java_tutorials/blob/master/src/ru/arhiser/parser/Main.java
//https://www.youtube.com/watch?v=iLnNqqom5KY&list=PL5BhKu-LkR_0mDGftRWeaakqGuYE1ToGG&index=14

class MathExpressionTest {
  @Test
  fun testMathExpressionTest() {
    val input = "22 + 3 - 2 * (2 * 5 + 2) * 4"
    val result = parseExpressionToBinaryTree(input.replace(" ", "")).calc()
    println(result)
  }
}

fun parseExpressionToBinaryTree(expression: String): Node {
  openBrackets(expression)
  TODO()
}

class ExpressionWithPriority(val expression: String, val priority: Int)

fun openBrackets(expression: String): List<ExpressionWithPriority> {
  for (i in expression.indices) {
    val stack:Stack<Int> = Stack()
    if (expression[i] == '(') {
      stack.add(i)
    }
    if (expression[i] == ')') {
      val openBracketIndex = stack.pop()
      if (stack.size == 0) {

      }
    }
  }
  TODO()
}

interface Node {
  fun calc(): Float
}

class Parent(val left: Node, val right: Node, operation: String) : Node {
  override fun calc(): Float {
    left.calc()
    right.calc()
    TODO()
  }

}
