package backjun.g3

import java.util.*

class NumberK {

    fun main() {
        val sc = Scanner(System.`in`)

        var N: Long = sc.nextLong()
        var K: Long = sc.nextLong()

        var left: Long = 1
        var right: Long = K
        var ans: Long = 0

        // 이분 탐색 수행
        while (left <= right) {
            val mid = (left + right) / 2 // 임의의 수 지정
            var cnt: Long = 0

            // mid보다 작거나 같은 수는 몇 개인지 계산.
            for (i in 1..N) {
                cnt += Math.min(mid / i, N)
            }
            if (cnt < K) {
                left = mid + 1
            } else {
                ans = mid
                right = mid - 1
            }
        }

        println(ans)
    }
}