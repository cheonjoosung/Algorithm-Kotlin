package backjun.g3

import java.util.*

class MulArray {

    var answer = Long.MAX_VALUE

    fun main() {

        val sc = Scanner(System.`in`)

        val n = sc.nextInt()
        var pairs = mutableListOf<Pairs>()
        var dp = Array(n) { IntArray(n) { Integer.MAX_VALUE } }

        for (i in 0 until n) {
            val x = sc.nextInt()
            val y = sc.nextInt()

            pairs.add(Pairs(x, y))
        }

        /*
            1. dp[i][j]에는 i번과 j번의 곱셈 횟수가 저장된다.

         */
        //3 5 3 3 2 2 6
        //4 1 3 3 2 2 2 2 2

        println(solve(0, n - 1, dp, pairs))
        sc.close()
    }

    fun solve(start: Int, end: Int, dp: Array<IntArray>, pairs: MutableList<Pairs>): Int {

        if (start == end) return 0;

        if (dp[start][end] != Integer.MAX_VALUE) {
            return dp[start][end];
        }

        /*
            1. dp[i][j]에는 i번과 j번의 곱셈 횟수가 저장된다.
            2. dp[0][2] -> dp[0][1] * 두번째 행렬 또는 0번째 행렬 & dp[1][2] 중 최소값이 남게됨
            3. solve(start to i) + solve(i+1 to end) + cost(start지점의 x * i지점 x * 마지막점의 y)
            4. 동적계획법.. DP 어렵네
         */
        for (i in start until end) {
            var cost =
                solve(start, i, dp, pairs) +
                        solve(i + 1, end, dp, pairs) +
                        (pairs[start].x * pairs[i].y * pairs[end].y)
            dp[start][end] = Math.min(dp[start][end], cost)
        }
        return dp[start][end];
    }
}

data class Pairs(var x: Int, var y: Int)