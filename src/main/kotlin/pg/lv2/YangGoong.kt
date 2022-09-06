package pg.lv2

import java.util.*


class YangGoong {

    var answer = ArrayList<IntArray>()
    lateinit var ryan: IntArray
    lateinit var apeach: IntArray

    var N = 0
    var max = Int.MIN_VALUE

    fun solution(n: Int, info: IntArray): IntArray {

        ryan = IntArray(11)
        N = n

        apeach = info.clone()

        dfs(0, 0)
        if (answer.isEmpty()) return intArrayOf(-1)

        Collections.sort(answer) { o1, o2 ->
            for (i in 10 downTo 0) {
                if (o1.get(i) != o2.get(i)) return@sort o2.get(i) - o1.get(i)
            }
            0
        }

        return answer[0]
    }

    private fun dfs(L: Int, s: Int) {
        if (L == N) {
            var a = 0
            var r = 0

            for (i in 0..10) {
                if (apeach[i] == 0 && ryan[i] == 0) continue
                if (apeach[i] < ryan[i]) r += 10 - i else a += 10 - i
            }

            if (r > a) {
                val diff = r - a
                if (diff > max) {
                    max = diff
                    answer.clear()
                    answer.add(ryan.clone())
                } else if (diff == max) answer.add(ryan.clone())
            }

        } else {
            for (i in s..10) {
                ryan[i]++
                dfs(L + 1, i)
                ryan[i]--
            }
        }
    }
}