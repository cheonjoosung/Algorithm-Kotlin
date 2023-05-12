package pg.lv0

fun main() {
    TowArraySearch().solution(
        arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(1, 2, 3),
            intArrayOf(2, 3, 4),
            intArrayOf(3, 4, 5)
        ), 2
    ).also { println(it) }
}

class TowArraySearch {

    fun solution(board: Array<IntArray>, k: Int): Int {
        var answer: Int = 0

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (i + j <= k) {
                    answer += board[i][j]
                }
            }
        }

        return answer
    }
}