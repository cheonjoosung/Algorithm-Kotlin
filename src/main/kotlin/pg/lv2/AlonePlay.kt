package pg.lv2

class AlonePlay {
    var answer: Int = 0
    fun solution(cards: IntArray): Int {

        val maxSize = cards.size - 1
        /**
         * maxSize 가 되는 모든 경우의 수를 구하는...
         * 1,6 1,5,1 1,4,2 1,3,3 , 1,2,4
         */

        var arr = intArrayOf()
        for (n in 2 until maxSize) {
            dfs(1, 0, n, maxSize, 0, 1)
        }
        return answer
    }

    private fun dfs(idx: Int, cnt: Int, n: Int, maxSize: Int, sum: Int, mul: Int) {
        if (cnt == n && sum == maxSize) {
            answer = answer.coerceAtLeast(mul)
            return
        }

        for (i in idx until maxSize) {
            if (sum + i > maxSize) continue
            dfs(i, cnt+1, n, maxSize, sum+i, mul*i)
        }
    }
}

fun main() {
    AlonePlay().solution(intArrayOf(8,6,3,7,2,5,1,4)).also { println(it) }
}