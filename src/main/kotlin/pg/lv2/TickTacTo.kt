package pg.lv2

class TickTacTo {
    fun solution(board: Array<String>): Int {
        var answer: Int = 0

        val row = 3
        val col = 3

        var oCount = 0
        var xCount = 0

        val arr = Array(row) { CharArray(col) { '.' } }
        for (i in 0 until row) {
            for (j in 0 until col) {
                arr[i][j] = board[i][j]

                if (arr[i][j] == 'O') oCount++
                else if (arr[i][j] == 'X') xCount++
            }
        }

        val oRowPossible = isRowOneLine(arr, 'O')
        val oColPossible = isColOneLine(arr, 'O')
        val oDiagonalPossible = isDiagonalOneLine(arr, 'O')

        var oPossibleCount = 0
        if (oRowPossible) oPossibleCount++
        if (oColPossible) oPossibleCount++
        if (oDiagonalPossible) oPossibleCount++

        val xRowPossible = isRowOneLine(arr, 'X')
        val xColPossible = isColOneLine(arr, 'X')
        val xDiagonalPossible = isDiagonalOneLine(arr, 'X')

        var xPossibleCount = 0
        if (xRowPossible) xPossibleCount++
        if (xColPossible) xPossibleCount++
        if (xDiagonalPossible) xPossibleCount++

        if (xCount > oCount || xPossibleCount > 1 || oPossibleCount > 2) answer = 0
        else {

            val oPossible = (oRowPossible || oColPossible || oDiagonalPossible)
            val xPossible = (xRowPossible || xColPossible || xDiagonalPossible)

            when {
                !xPossible && !oPossible -> {
                    answer = if (oCount == xCount + 1 || oCount == xCount) 1
                    else 0
                }

                xPossible && !oPossible -> {
                    answer = if (oCount == xCount) 1
                    else 0
                }

                !xPossible && oPossible -> {
                    answer = if (oCount == xCount + 1) 1
                    else 0
                }

                else -> {
                    answer = 0
                }
            }
        }

        return answer
    }

    private fun isRowOneLine(arr: Array<CharArray>, target: Char): Boolean {
        for (i in 0..2) {
            if (arr[i].all { it == target }) return true
        }
        return false
    }

    private fun isColOneLine(arr: Array<CharArray>, target: Char): Boolean {
        for (i in 0..2) {
            if ((0..2).all { arr[it][i] == target }) return true
        }
        return false
    }

    private fun isDiagonalOneLine(arr: Array<CharArray>, target: Char): Boolean {
        if ((0..2).all { arr[it][it] == target }) return true
        if ((0..2).all { arr[it][2 - it] == target }) return true
        return false
    }

}

fun main() {

    TickTacTo().solution(arrayOf("O.X", ".O.", "..X")).also { println(it) } //1
    TickTacTo().solution(arrayOf("OOO", "...", "XXX")).also { println(it) } //0
    TickTacTo().solution(arrayOf("...", ".X.", "...")).also { println(it) } //0
    TickTacTo().solution(arrayOf("...", "...", "...")).also { println(it) } //1
    TickTacTo().solution(arrayOf("X..", ".X.", "..X")).also { println(it) } //0
    TickTacTo().solution(arrayOf("X..", ".X.", ".OO")).also { println(it) } //1
    TickTacTo().solution(arrayOf("X.O", "XO.", "OOO")).also { println(it) } //0
    TickTacTo().solution(arrayOf("OXO", "OXO", "XOX")).also { println(it) } //1
}