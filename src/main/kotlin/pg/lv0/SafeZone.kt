package pg.lv0

fun main() {
    //[[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]
    val board = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 1, 0),
        intArrayOf(0, 0, 0, 0, 0)
    )
    SafeZone().solution(board).run { print(this) }
}

class SafeZone {

    fun solution(board: Array<IntArray>): Int {
        var answer: Int = 0

        val row = board.size
        val col = board[0].size

        for (i in board.indices) {
            for (j in board[i].indices) {
                isSafe(board, i, j, row, col)
            }
        }

        for (i in board.indices) {
            for (j in board[i].indices) {
                print("${board[i][j]} ")
                if (board[i][j] == 0) answer++
            }
            println()
        }

        return answer
    }

    private fun isSafe(board: Array<IntArray>, x: Int, y: Int, row: Int, col: Int) {

        val dx = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)
        val dy = intArrayOf(1, 1, 0, -1, -1, -1, 0, 1)

        for (d in 0..7) {
            val nx = x + dx[d]
            val ny = y + dy[d]

            if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue
            if (board[nx][ny] == 1) {
                if (board[x][y] != 1) board[x][y] = 2
            }
        }
    }
}