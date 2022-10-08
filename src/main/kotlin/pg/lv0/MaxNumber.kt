package pg.lv0

class MaxNumber {

    fun solution(array: IntArray): IntArray {
        val max = array.maxOrNull()!!
        array.maxOf { it }
        val idx = array.indexOf(max)

        return intArrayOf(max ,idx)
    }
}