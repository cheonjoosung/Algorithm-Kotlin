package pg.lv2

fun main () {
    ContinueNumberSum().solution(intArrayOf(7, 9, 1, 1, 4)).also { println(it) }
}

class ContinueNumberSum {

    fun solution(elements: IntArray): Int {

        val newArr = IntArray(elements.size * 2) { 0 }

        for (i in newArr.indices) {
            newArr[i] = elements[i % elements.size]
        }

        val set = mutableSetOf<Int>()

        for (i in 1..elements.size) {
            for (j in 0..elements.size) {
                set.add(newArr.copyOfRange(j, j+i).sum())
            }
        }

        return set.size
    }

}