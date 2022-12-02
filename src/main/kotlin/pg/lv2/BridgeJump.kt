package pg.lv2

fun main() {
    BridgeJump().solution(intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1), 3).also { println(it) }
    // 3
}

class BridgeJump {

    var end = 0
    var answer = 0

    fun solution(stones: IntArray, k: Int): Int {
        answer = 0
        end = stones.maxOrNull()!!

        bs(1, end, stones, k)

        return answer
    }

    private fun bs(s: Int, e: Int, stones: IntArray, k: Int) {
        val mid = (s + e) / 2

        if (s > e) return

        if (check(mid, stones, k)) {
            answer = answer.coerceAtLeast(mid)
            bs(mid + 1, e, stones, k)
        } else {
            bs(s, mid - 1, stones, k)
        }
    }

    private fun check(mid: Int, stones: IntArray, k: Int): Boolean {
        val temp = IntArray(stones.size) { stones[it] - mid }

        var idx = -1
        for (i in temp.indices) {
            if (temp[i] > 0) {
                if (i - idx > k) return false
                idx = i
            }
        }

        if (idx < 0) return false
        if (temp.size - idx > k) return false
        return true
    }
}