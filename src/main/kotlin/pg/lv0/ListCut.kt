package pg.lv0

fun main() {
    ListCut().solution(3, intArrayOf(1, 5, 2), intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)).forEach { println(it) }
    ListCut().solution(4, intArrayOf(1, 5, 2), intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)).forEach { println(it) }
}

class ListCut {

    fun solution(n: Int, slicer: IntArray, num_list: IntArray): IntArray {
        val list = mutableListOf<Int>()

        val (a, b, c) = slicer

        when (n) {
            1 -> (0..b).forEach { list.add(num_list[it]) }
            2 -> (a until num_list.size).forEach { list.add(num_list[it]) }
            3 -> (a..b).forEach { list.add(num_list[it]) }
            4 -> (a..b step c).forEach { list.add(num_list[it]) }
        }

        return list.toIntArray()
    }
}