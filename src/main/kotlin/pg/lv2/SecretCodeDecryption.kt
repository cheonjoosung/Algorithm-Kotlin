package pg.lv2

fun solution(n: Int, q: Array<IntArray>, ans: IntArray): Int {
    val combinations = mutableListOf<List<Int>>()
    generateCombinations(1, n, 5, mutableListOf(), combinations)

    var validCount = 0
    for (candidate in combinations) {
        if (isValid(candidate, q, ans)) {
            validCount++
        }
    }
    return validCount
}

private fun generateCombinations(
    start: Int,
    end: Int,
    k: Int,
    current: MutableList<Int>,
    result: MutableList<List<Int>>
) {
    if (current.size == k) {
        result.add(current.toList())
        return
    }

    for (i in start..end) {
        current.add(i)
        generateCombinations(i + 1, end, k, current, result)
        current.removeAt(current.size - 1)
    }
}

private fun isValid(candidate: List<Int>, q: Array<IntArray>, ans: IntArray): Boolean {
    val candidateSet = candidate.toSet()
    for (i in q.indices) {
        val matchCount = q[i].count { it in candidateSet }
        if (matchCount != ans[i]) return false
    }
    return true
}

fun main() {
    //[[], [], [], [], []]	[]	5
    solution(
        10,
        arrayOf(
            intArrayOf(1, 2, 3, 4, 5), // 2
            intArrayOf(6, 7, 8, 9, 10), // 3
            intArrayOf(3, 7, 8, 9, 10), // 4
            intArrayOf(2, 5, 7, 9, 10), // 3
            intArrayOf(3, 4, 5, 6, 7) // 3
        ),
        intArrayOf(2, 3, 4, 3, 3)
    ).also { println(it) } //3
    solution(
        15,
        arrayOf(
            intArrayOf(2, 3, 9, 12, 13),
            intArrayOf(1, 4, 6, 7, 9),
            intArrayOf(1, 2, 8, 10, 12),
            intArrayOf(6, 7, 11, 13, 15),
            intArrayOf(1, 4, 10, 11, 14)
        ),
        intArrayOf(2, 1, 3, 0, 1)
    ).also { println(it) } //5
}