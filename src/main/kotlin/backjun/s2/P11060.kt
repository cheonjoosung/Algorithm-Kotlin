import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val arr = IntArray(n + 1) { 0 }
    val dp = IntArray(n + 1) { Integer.MAX_VALUE }
    dp[1] = 0

    for (i in 1..n)
        arr[i] = sc.nextInt()

    for (i in 1..n) {
        if (dp[i] >= Integer.MAX_VALUE) continue

        for (j in 1..arr[i]) {
            if (i + j > n) continue
            dp[i+j] = Math.min(dp[i+j], dp[i] + 1)
        }
    }

    val ans = if (dp[n] == Integer.MAX_VALUE) -1 else dp[n]
    println(ans)
}