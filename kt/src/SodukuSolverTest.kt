import org.junit.Test
import kotlin.random.Random
import kotlin.test.assertEquals

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
    }

}

fun solveSudoku(matrix:List<List<String>>) {

}
