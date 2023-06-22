package pg.lv2

class Rocket {
    fun solution(targets: Array<IntArray>): Int {
        val missileRanges = targets.map { MissileRange(it[0], it[1]) }.sortedBy { it.end }
        var count = 0
        var currentEnd = Int.MIN_VALUE

        for (range in missileRanges) {
            if (currentEnd < range.start || currentEnd >= range.end) {
                count++
                currentEnd = range.end - 1
            }
        }

        return count
    }
}

data class MissileRange(val start: Int, val end: Int)

fun main () {
    Rocket().solution(
        arrayOf(
            intArrayOf(4,5), intArrayOf(4,8), intArrayOf(10,14), intArrayOf(11,13),
            intArrayOf(5,12), intArrayOf(3,7), intArrayOf(1,4)
        )
    ).also { println(it) } //3
}