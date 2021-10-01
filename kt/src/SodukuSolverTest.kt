import org.junit.Test
import kotlin.math.roundToInt
import kotlin.math.sqrt

class SodukuSolverTest {
  @Test
  fun solveSoduku2x2() {
    // let input = [
    //     [".", ".", "1", "."],
    //     [".", ".", ".", "."],
    //     [".", ".", "3", "."],
    //     [".", ".", "2", "."],
    // ];

    // let input = [
    //     ["4", ".", "1", "."],
    //     [".", "2", ".", "."],
    //     [".", ".", "3", "."],
    //     [".", ".", "2", "."],
    // ];
  }

  @Test
  fun solveSudoku3x3() {
    val input = listOf(
      listOf("5", "3", ".", ".", "7", ".", ".", ".", "."),
      listOf("6", ".", ".", "1", "9", "5", ".", ".", "."),
      listOf(".", "9", "8", ".", ".", ".", ".", "6", "."),
      listOf("8", ".", ".", ".", "6", ".", ".", ".", "3"),
      listOf("4", ".", ".", "8", ".", "3", ".", ".", "1"),
      listOf("7", ".", ".", ".", "2", ".", ".", ".", "6"),
      listOf(".", "6", ".", ".", ".", ".", "2", "8", "."),
      listOf(".", ".", ".", "4", "1", "9", ".", ".", "5"),
      listOf(".", ".", ".", ".", "8", ".", ".", "7", "9"),
    );
    println(solveSudokuString(input))
  }

}

//https://codepen.io/puzankov/pen/eYZyZPX?editors=0012
fun solveSudokuString(input: List<List<String>>): SudokuResult {
  val matrix: List<List<Int?>> = input.map { it.map { it.toIntOrNull() } }
  return solveSudoku(Matrix(matrix))
}

sealed class SudokuResult {
  object Fail : SudokuResult()
  data class Success(val matrix: Matrix) : SudokuResult()
}

fun solveSudoku(matrix: Matrix): SudokuResult {
  for (x in 0 until matrix.size) {
    for (y in 0 until matrix.size) {
      if (matrix[x, y] == null) {
        val available = matrix.allValues - matrix.colValues(x) - matrix.rowValues(y) - matrix.blockValues(x, y)
        available.forEach {
          val tempResult: SudokuResult = solveSudoku(matrix.copy(x, y, it))
          if (tempResult is SudokuResult.Success) {
            return tempResult
          }
        }
        return SudokuResult.Fail
      }
    }
  }
  return SudokuResult.Success(matrix)
}

class Matrix(val raw: List<List<Int?>>) {
  val size: Int = raw.size
  val blockSize = sqrt(size.toDouble()).roundToInt()
  val allValues: List<Int> = (1..size).toList()
  operator fun get(x: Int, y: Int): Int? = raw[x][y]
  fun copy(x: Int, y: Int, value: Int): Matrix = Matrix(raw = raw.replace(x, raw[x].replace(y, value)))
  fun colValues(x: Int): List<Int> = raw[x].filterNotNull()
  fun rowValues(y: Int): List<Int> = raw.mapNotNull { it[y] }
  fun blockValues(x: Int, y: Int): List<Int> {
    val result = mutableListOf<Int>()
    val blockStartX = (x / blockSize) * blockSize
    val blockStartY = (y / blockSize) * blockSize
    for (bx in blockStartX until (blockStartX + blockSize)) {
      for (by in blockStartY until (blockStartY) + blockSize) {
        val value = raw[x][y]
        if (value != null) {
          result.add(value)
        }
      }
    }
    return result
  }

  override fun toString(): String = buildString {
    appendLine()
    raw.forEach {
      appendLine(it.toString())
    }
  }
}

fun <T> List<T>.replace(index: Int, value: T): List<T> = slice(0 until index) + listOf(value) + slice(index + 1 until size)
