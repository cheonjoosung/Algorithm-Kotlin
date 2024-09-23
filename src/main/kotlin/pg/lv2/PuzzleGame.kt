package pg.lv2

fun main() {
    PuzzleGame().solution(
        intArrayOf(1, 99999, 1000000),
        intArrayOf(9999,9001,9999,9001),
        3456789012
    ).also { println(it) } //39354
}

class PuzzleGame {
    fun solution(diffs: IntArray, times: IntArray, limit: Long): Int {

        fun canSolveAllPuzzles(level: Int): Boolean {
            var totalTime = 0L
            var previousTime = times[0]

            for (i in diffs.indices) {
                val diff = diffs[i]
                val timeCur = times[i]

                if (diff <= level) {
                    totalTime += timeCur
                } else {
                    val mistakes = diff - level
                    totalTime += (timeCur + previousTime) * mistakes + timeCur
                }

                // 이전 퍼즐의 소요 시간을 갱신
                previousTime = timeCur

                if (totalTime > limit) return false
            }

            return totalTime <= limit
        }

        // 이분 탐색으로 최적의 Level 찾기
        var left = 1
        var right = 100000
        var answer: Int = right

        while (left <= right) {
            val mid = (left + right) / 2

            if (canSolveAllPuzzles(mid)) {
                answer = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return answer
    }

}