package pg.lv0

fun main() {
    MoreFrequencyNumber().solution(intArrayOf(1, 2, 3, 3, 3, 4))
}

class MoreFrequencyNumber {

    fun solution(array: IntArray): Int {
        return array
            .groupBy { it }
            .map { it.value.size to it.key }
            .sortedByDescending { it.first }
            .let {
                when {
                    it.size == 1 -> it.first().second
                    it.first().first == it[1].first -> - 1
                    else -> it.first().second
                }
            }
    }
}