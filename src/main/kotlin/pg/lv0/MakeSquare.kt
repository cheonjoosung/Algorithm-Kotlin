package pg.lv0

fun main() {
    MakeSquare().solution(
        arrayOf(
            intArrayOf(572, 22, 37), intArrayOf(287, 726, 384), intArrayOf(85, 137, 292), intArrayOf(487, 13, 876)
        )
    ).forEach {
        println(it)
    }

    MakeSquare().solution(
        arrayOf(
            intArrayOf(57, 192, 534, 2), intArrayOf(9, 345, 192, 999)
        )
    ).forEach {
        println(it)
    }

    MakeSquare().solution(
        arrayOf(
            intArrayOf(1, 2), intArrayOf(3, 4)
        )
    ).forEach { println(it) }
}

class MakeSquare {

    fun solution(arr: Array<IntArray>): Array<IntArray> {

        val row = arr.size
        val col = arr[0].size

        return if (row == col) {
            arr
        } else {
            val n = row.coerceAtLeast(col)
            val answer = Array(n) { IntArray(n) { 0 } }

            for (i in arr.indices) {
                for (j in arr[i].indices) {
                    answer[i][j] = arr[i][j]
                }
            }
            answer
        }
    }
}