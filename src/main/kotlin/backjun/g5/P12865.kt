package backjun.g5

import java.util.*

fun main() {

    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val k = sc.nextInt()

    val W = IntArray(n + 1) { 0 }
    val V = IntArray(n + 1) { 0 }

    val dp = Array(n + 1) { IntArray(k + 1) { 0 } }

    (1..n).forEach {
        W[it] = sc.nextInt()
        V[it] = sc.nextInt()
    }

    for (i in 1..n) {
        for (j in 1..k) {
            if (W[i] > j) { // i번쨰 무게를 더 담을 수 없는 경우
                dp[i][j] = dp[i - 1][j]
            } else { // i번째 무게를 더 담을 수 있는 경우
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i])
            }
        }
    }

    println(dp[n][k])

    sc.close()
}