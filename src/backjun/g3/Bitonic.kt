package backjun.g3

import java.util.*

class Bitonic {

    fun solution() {
        val sc = Scanner(System.`in`)
        var answer = 1

        val n = sc.nextInt()
        var num = Array<Int>(n) { 0 }
        var dp = Array<Int>(1001) { 1 }
        var dp2 = Array<Int>(1002) { 0 }

        for (i in 0 until n)
            num[i] = sc.nextInt()

        for (i in 0 until n) {
            for (j in 0 until i) {
                if (num[j] < num[i]) dp[i] = Math.max(dp[i], dp[j] + 1) //앞에서 증가
            }
            answer = Math.max(answer, dp[i])
        }

        for (i in (n-1) downTo 0) {
            for (j in (n-1) downTo (i+1)) {
                if (num[j] < num[i]) dp2[i] = Math.max(dp2[i], dp2[j]+1) //뒤에서 증가
            }
            answer = Math.max(answer, dp[i]+dp2[i])
        }

        println(answer)

    }
}