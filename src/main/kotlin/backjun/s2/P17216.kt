package backjun.s2

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }
    val dp = a.toMutableList()

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (a[i] < a[j]) {
                dp[i] = Math.max(dp[i], dp[j] + a[i])
            }
        }
    }

    println(dp.maxOf { it })
}