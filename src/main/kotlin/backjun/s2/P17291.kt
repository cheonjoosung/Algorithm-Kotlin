package backjun.s2

fun main() {
    val n = readln().toInt()

    val dp = LongArray(21)
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    dp[4] = 7

    for (i in 5..20) {
        dp[i] = dp[i - 1] * 2

        if (i % 2 == 0) {
            dp[i] -= dp[i - 4] + dp[i - 5]
        }
    }

    println(dp[n])
}