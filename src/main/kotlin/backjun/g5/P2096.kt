package backjun.g5

import java.util.*

fun main() {

    val scan = Scanner(System.`in`)

    val n = scan.nextInt()
    val board = Array(n + 1) { IntArray(3) }
    for (i in 1..n) {
        for (j in 0..2) {
            board[i][j] = scan.nextInt()
        }
    }

    val minDp = Array(n + 1) { IntArray(3) }
    val maxDp = Array(n + 1) { IntArray(3) }

    for (i in 1..n) {
        maxDp[i][0] += Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + board[i][0]
        maxDp[i][1] += Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + board[i][1]
        maxDp[i][2] += Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + board[i][2]

        minDp[i][0] += Math.min(minDp[i - 1][0], minDp[i - 1][1]) + board[i][0]
        minDp[i][1] += Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + board[i][1]
        minDp[i][2] += Math.min(minDp[i - 1][1], minDp[i - 1][2]) + board[i][2]
    }

    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE

    for (i in 0..2) {
        min = Math.min(min, minDp[n][i])
        max = Math.max(max, maxDp[n][i])
    }

    println("$max $min")
}