package backjun.g4

import java.util.*

class DownToLoad {

    val dx = intArrayOf(0, -1, 0, 1)
    val dy = intArrayOf(1, 0, -1, 0)

    fun main() {
        val sc = Scanner(System.`in`)

        val r = sc.nextInt()
        val c = sc.nextInt()

        val array = Array(r + 1) { IntArray(c + 1) { 0 } }
        val dp = Array(r+1) { IntArray(c+1) { -1 } }

        for (i in 1..r) {
            for (j in 1..c) {
                array[i][j] = sc.nextInt()
            }
        }

        println( find(1, 1, r, c, array, dp))

        sc.close()
    }

    private fun find(x: Int, y: Int, row: Int, col: Int, array: Array<IntArray>, dp: Array<IntArray>): Int {

        if (x == row && y == col) {
            return 1
        }

        if (dp[x][y] != -1) {
            return dp[x][y]
        } else {
            dp[x][y] = 0

            for (d in 0..3) {
                val nx = x + dx[d]
                val ny = y + dy[d]

                if (nx <= 0 || ny <= 0 || nx > row || ny > col) continue
                if (array[nx][ny] < array[x][y]) {
                    dp[x][y] += find(nx, ny, row, col, array, dp)
                }
            }
        }

        return dp[x][y]
    }
}