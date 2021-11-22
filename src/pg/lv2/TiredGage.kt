package pg.lv2

import java.util.*

class TiredGage {

    var answer = 0

    fun solution(k: Int, dungeons: Array<IntArray>): Int {

        dfs(k, IntArray(dungeons.size) { 0 }, dungeons, 0, BooleanArray(dungeons.size) { false })
        return answer
    }

    private fun dfs(k: Int, output: IntArray, dungeons: Array<IntArray>, idx: Int, visited: BooleanArray) {
        if (idx == dungeons.size) {

            var current = k
            var count = 0

            for (i in output) {
                if (current >= dungeons[i][0]) {
                    current -= dungeons[i][1]
                    count += 1
                }
            }

            answer = Math.max(count, answer)
            return
        }

        for (i in dungeons.indices) {
            if (visited[i]) continue

            visited[i] = true
            output[idx] = i
            dfs(k, output, dungeons, idx + 1, visited)
            visited[i] = false
        }
    }
}
