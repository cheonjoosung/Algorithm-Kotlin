package leet_code.easy
class P70_ClimbingStairs {
    fun climbStairs(n: Int): Int {
        return when (n) {
            1 -> 1
            2 -> 2
            else -> {
                val dp = IntArray(n + 1) { 0 }
                dp[1] = 1
                dp[2] = 2

                for (i in 3..n) {
                    dp[i] = dp[i-1] + dp[i-2]
                }

                dp[n]
            }
        }
    }
}

fun main() {
    P70_ClimbingStairs().climbStairs(2).also { println(it) }
    P70_ClimbingStairs().climbStairs(3).also { println(it) }
    P70_ClimbingStairs().climbStairs(4).also { println(it) }
    P70_ClimbingStairs().climbStairs(5).also { println(it) }
    P70_ClimbingStairs().climbStairs(6).also { println(it) }
}