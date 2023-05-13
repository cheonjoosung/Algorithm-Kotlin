package pg.lv0

fun main() {
    TwoAround().solution(intArrayOf(1, 1, 1)).forEach { println(it) }
    TwoAround().solution(intArrayOf(1, 2, 1, 4, 5, 2, 9)).forEach { println(it) }
}

class TwoAround {

    fun solution(arr: IntArray): IntArray {

        return if (arr.contains(2)) {
            val firstIndex = arr.indexOfFirst { it == 2 }
            val lastIndex = arr.indexOfLast { it == 2 }

            return arr.copyOfRange(firstIndex, lastIndex + 1)
        } else {
            intArrayOf(-1)
        }
    }
}