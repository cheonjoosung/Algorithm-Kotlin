package pg.lv0

fun main() {
    EmptyArrayAddDelete().solution(intArrayOf(3, 2, 4, 1, 3), booleanArrayOf(true, false, true, false, false)).forEach {
        println(it)
    }

}

class EmptyArrayAddDelete {

    fun solution(arr: IntArray, flag: BooleanArray): IntArray {
        val list = mutableListOf<Int>()

        arr.forEachIndexed { index, i ->
            if (flag[index]) {
                repeat(2*i) { list.add(i) }
            } else {
                repeat(i) { list.removeLast() }
            }
        }

        return list.toIntArray()
    }
}