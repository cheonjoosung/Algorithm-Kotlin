import java.util.*

fun main() {

    val sc = Scanner(System.`in`)
    // 나이트의 이동

    val n = sc.nextInt()
    val arr = Array(n + 1) { IntArray(n + 1) { 0 } }
    val dp = Array(n + 1) { LongArray(n + 1) { 0 } }


    for (i in 1..n) {
        for (j in 1..n) {
            arr[i][j] = sc.nextInt()
        }
    }

    dp[1][1] = 1

    for (i in 1..n) {
        for (j in 1..n) {
            val next = arr[i][j]
            if (next == 0) break

            if (j + next <= n) dp[i][j + next] += dp[i][j]
            if (i + next <= n) dp[i + next][j] += dp[i][j]
        }
    }

    println(dp[n][n])
}