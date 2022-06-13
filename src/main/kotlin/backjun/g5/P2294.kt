package backjun.g5

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val k = sc.nextInt()

    val coin = IntArray(n)
    for (i in 0 until n) {
        coin[i] = sc.nextInt()
    }

    val dp = IntArray(k + 1) { 100001 }
    dp[0] = 0

    /**
     * 최소한의 동전수로 만들수 있는 금액
     */
    for (i in 0 until n) {
        for (j in coin[i]..k) {
            dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1)
        }
    }

    println(if (dp[k] == 100001) -1 else dp[k])
    sc.close()
}