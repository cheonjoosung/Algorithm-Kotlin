package pg.lv1

fun main() {
    ThreeMans().solution(intArrayOf(-2, 3, 0, 2, -5)).also { println(it) }
    ThreeMans().solution(intArrayOf(-3, -2, -1, 0, 1, 2, 3)).also { println(it) }
    ThreeMans().solution(intArrayOf(-1, 1, -1, 1)).also { println(it) }
}

class ThreeMans {

    var answer = 0

    fun solution(number: IntArray): Int {

        val visit = BooleanArray(number.size) { false }

        dfs(0, 0, number, visit)

        return answer
    }

    private fun dfs(idx: Int, cnt: Int, number: IntArray, visit: BooleanArray) {

        if (cnt == 3) {
            var sum = 0

            for (i in number.indices) {
                if (visit[i]) {
                    sum += number[i]
                }
            }

            if (sum == 0) answer++
            return
        }

        for (i in idx until number.size) {
            if (visit[i]) continue

            visit[i] = true
            dfs(i, cnt + 1, number, visit)
            visit[i] = false
        }
    }
}