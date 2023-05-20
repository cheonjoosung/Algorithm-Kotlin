package pg.lv0

fun main() {
    ArrayCut().solution(intArrayOf(0, 1, 2, 3, 4, 5), intArrayOf(4, 1, 2)).forEach { println(it) }
}

class ArrayCut {

    fun solution(arr: IntArray, query: IntArray): IntArray {

        val list = arr.toMutableList()

        query.forEachIndexed { index, value ->
            val newTemp = if (index % 2 == 0) {
                list.filterIndexed { idx, _ ->
                    value >= idx
                }.toIntArray()
            } else {
                list.filterIndexed { idx, _ ->
                    value <= idx
                }.toIntArray()
            }

            list.clear()
            list.addAll(newTemp.toMutableList())
        }

        return list.toIntArray()
    }
}