package leetcode

fun main() {
  val greenTriangle:GeometricShape = Triangle(
    GreenColor()
  )
  greenTriangle.drawFigure()
}

private abstract class GeometricShape(val color:Color) { // Bridge Abstraction
  protected fun draw(text:String) {
    color.useColor()
    println("draw $text")
  }
  abstract fun drawFigure()
}

private class Triangle(color: Color) : GeometricShape(color) {
  override fun drawFigure() {
    draw("Triangle")
  }
}

private class Rectangle(color: Color) : GeometricShape(color) {
  override fun drawFigure() {
    draw("Rectangle")
  }
}

private interface Color { // Bridge Implementation
  fun useColor()
}

private class RedColor():Color {
  override fun useColor() {
    println("take Red color")
  }
}

private class GreenColor():Color {
  override fun useColor() {
    println("take Green color")
  }
}

