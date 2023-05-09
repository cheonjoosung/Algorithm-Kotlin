package pg.lv0

fun main() {
    SequenceIntervalQuery().solution(
        intArrayOf(0, 1, 2, 3, 4),
        arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3)
        )
    ).forEach { println(it) }
}

class SequenceIntervalQuery {

    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {

        queries.forEach {
            (it[0]..it[1]).forEach { index -> arr[index]++ }
        }

        return arr
    }
}