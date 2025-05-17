package backjun.s5

import java.math.BigInteger

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val num = br.readLine().toInt()

    val dp = Array(100001) { BigInteger.ZERO }

    dp[1] = BigInteger.ONE

    for(i in 2 .. num) {
        dp[i] = dp[i-1] + dp[i-2]
    }

    bw.write("${dp[num]}")
    bw.flush()
    bw.close()
    br.close()
}