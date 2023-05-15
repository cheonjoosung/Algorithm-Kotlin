package pg.lv0

fun main() {
    SequenceIntervalQuery4().solution(
        intArrayOf(0, 1, 2, 4, 3),
        arrayOf(
            intArrayOf(0, 4, 1),
            intArrayOf(0, 3, 2),
            intArrayOf(0, 3, 3)
        )
    ).forEach { println(it) }
}

class SequenceIntervalQuery4 {

    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {

        queries.forEach {
            val s = it[0]
            val e = it[1]
            val k = it[2]

            arr.forEachIndexed { index, i ->
                if (index in s..e) {
                    if (index % k == 0) arr[index]++
                }
            }

        }

        return arr
    }
}