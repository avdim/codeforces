package leetcode

import kotlin.reflect.KClass

fun main() {
  val figures: List<Figure> = listOf(
    Circle(),
    Rect(),
    Triangle(),
  )
  println(figures.interceptedFigures())
}

private fun List<Figure>.interceptedFigures(): Collection<Pair<Figure, Figure>> {
  val result: MutableList<Pair<Figure, Figure>> = mutableListOf()
  for (i in 0 until size) {
    for (j in i + 1 until size) {
      val visitor = InterceptGeometricWithVisitor()
      val a = get(i)
      val b = get(j)
      a.accept(visitor)
      visitor.isIntercepted(b)
      if (visitor.isIntercepted(b)) {
        result.add(Pair(a, b))
      }
    }
  }
  return result
}

private interface Figure {
  fun accept(visitor: Visitor)
}

private interface Visitor {
  fun visit(figure: Figure)
}

private class InterceptGeometricWithVisitor() : Visitor {

  private class Interceptor(
    val typeA: KClass<out Figure>,
    val typeB: KClass<out Figure>,
    val lambda: (a: Figure, b: Figure) -> Boolean
  )

  private var interceptedFun: ((Figure) -> Boolean)? = null
  private val interceptors: MutableList<Interceptor> = mutableListOf()

  init {
    register<Circle, Circle> { a, b -> false }
    register<Circle, Rect> { a, b -> true }
    register<Circle, Triangle> { a, b -> false }
    register<Rect, Rect> { a, b -> false }
    register<Rect, Triangle> { a, b -> false }
    register<Triangle, Triangle> { a, b -> false }
  }

  private inline fun <reified A : Figure, reified B : Figure> register(
    noinline isIntercepted: (a: Figure, b: Figure) -> Boolean
  ) {
    interceptors.add(Interceptor(A::class, B::class, isIntercepted))
  }

  override fun visit(figure: Figure) {
    val map = interceptors.filter {
      it.typeA.isInstance(figure)
    }.associate {
      it.typeB to { other: Figure -> it.lambda(figure, other) }
    } +
    interceptors.filter {
      it.typeB.isInstance(figure)
    }.associate {
      it.typeA to { other: Figure -> it.lambda(other, figure) }
    }
    interceptedFun = { other: Figure -> map[other::class]!!.invoke(other) }
  }

  fun isIntercepted(other: Figure): Boolean =
    interceptedFun?.invoke(other) ?: error("first need to call visit(element)")
}

private class Circle : Figure {
  override fun accept(visitor: Visitor) {
    visitor.visit(this)
  }
}

private class Rect : Figure {
  override fun accept(visitor: Visitor) {
    visitor.visit(this)
  }
}

private class Triangle : Figure {
  override fun accept(visitor: Visitor) {
    visitor.visit(this)
  }
}

