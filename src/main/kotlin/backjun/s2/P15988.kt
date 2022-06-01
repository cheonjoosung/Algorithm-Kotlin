import java.util.*

fun main() {

    val sc = Scanner(System.`in`)

    val tc = sc.nextInt()
    val sb = StringBuilder()

    val max = 1_000_000
    val div = 1_000_000_009

    val dp = LongArray (max + 1) { 0 }
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for (i in 4..max) {
        dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % div
    }

    (0 until tc).forEach { _ ->
        val num = sc.nextInt()
        sb.append(dp[num]).append("\n")
    }

    println(sb.toString())
}