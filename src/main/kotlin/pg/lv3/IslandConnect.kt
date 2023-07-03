package pg.lv3

class IslandConnect {
    fun solution(n: Int, costs: Array<IntArray>): Int {

        val sorted = costs.sortedBy { it[2] }
        val visitSet = mutableSetOf(sorted[0][0])

        var answer = 0
        while (visitSet.size < n) {
            for ((a,b,c) in sorted) {
                if (visitSet.contains(a) || visitSet.contains(b)) {
                    if (visitSet.contains(a) && visitSet.contains(b)) continue

                    visitSet.add(a)
                    visitSet.add(b)
                    answer += c
                    break
                }
            }
        }

        return answer
    }
}

fun main() {

    IslandConnect().solution(
        n = 4,
        costs = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(0, 2, 2),
            intArrayOf(1, 2, 5),
            intArrayOf(1, 3, 1),
            intArrayOf(2, 3, 8),
        )
    ).also { println(it) } // 4
}