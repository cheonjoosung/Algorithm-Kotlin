package backjun.g5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val t = br.readLine().split(" ").toTypedArray()

    /**
     * dp[i][j] = i번째 수까지 이용했을 때 j 0~20번째 수를 만들 수 있는가
     */
    val dp = Array(n + 1) { LongArray(21) }
    val arr = IntArray(n + 1)

    for (i in 1..n) {
        arr[i] = t[i - 1].toInt()
    }

    dp[1][arr[1]] = 1

    for (i in 2 until n) {
        for (j in 0..20) {
            if (dp[i - 1][j] != 0L) {
                if (j + arr[i] <= 20) {
                    dp[i][j + arr[i]] += dp[i - 1][j]
                }
                if (j - arr[i] >= 0) {
                    dp[i][j - arr[i]] += dp[i - 1][j]
                }
            }
        }
    }

    println(dp[n - 1][arr[n]])
}