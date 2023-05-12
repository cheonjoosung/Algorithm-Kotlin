package pg.lv0

fun main() {
    DateCompare().solution(intArrayOf(2021, 12, 28), intArrayOf(2021, 12, 29)).also { println(it) }
    DateCompare().solution(intArrayOf(1024, 10, 24), intArrayOf(1024, 10, 24)).also { println(it) }
}

class DateCompare {

    fun solution(date1: IntArray, date2: IntArray): Int {
        var answer: Int = 0

        val s1 = date1.joinToString("").toInt()
        val s2 = date2.joinToString("").toInt()
        return if (s1 > s2) 1 else 0
    }
}