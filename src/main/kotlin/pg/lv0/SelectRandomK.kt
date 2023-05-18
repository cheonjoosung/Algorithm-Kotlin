package pg.lv0

fun main() {
    SelectRandomK().solution(
        intArrayOf(0,1,1,2,2,3), 3).forEach { println(it) }

    SelectRandomK().solution(
        intArrayOf(0,1,1,1,1), 4).forEach { println(it) }
}

class SelectRandomK {

    fun solution(arr: IntArray, k: Int): IntArray {

        val list = arr.distinct().toMutableList()

        return if (list.size < k) {
            (1..(k-list.size)).forEach { _ ->
                list.add(-1)
            }
            list.toIntArray()
        } else {
            list.subList(0, k).toIntArray()
        }
    }
}