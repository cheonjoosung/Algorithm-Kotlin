package pg.lv0

fun main() {
    SequenceIntervalQuery2().solution(
        intArrayOf(0, 1, 2, 4, 3),
        arrayOf(
            intArrayOf(0, 4, 2),
            intArrayOf(0, 3, 2),
            intArrayOf(0, 2, 2)
        )
    ).forEach { println(it) }
}

class SequenceIntervalQuery2 {

    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        val answer = IntArray(queries.size) { -1 }

        queries.forEachIndexed { answerIndex, it ->
            val s = it[0]
            val e = it[1]
            val k = it[2]

            answer[answerIndex] = arr.filterIndexed { index, _ ->
                index in s..e
            }.sorted().find { value -> value > k } ?: -1
        }

        return answer
    }
}