package backjun.g5

import java.util.*

class P2293 {

    fun main() {
        val sc = Scanner(System.`in`)

        val n = sc.nextInt()
        val sum = sc.nextInt()

        val array = IntArray(n + 1) { 0 }
        val dp = IntArray(sum + 1) { 0 }

        dp[0] = 1

        for (i in 1..n)
            array[i] = sc.nextInt()

        for (i in 1..n) {
            for (j in array[i]..sum) {
                dp[j] += dp[j - array[i]]
            }
        }

        println(dp[sum])
        sc.close()
    }
}