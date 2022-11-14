package pg.lv0

fun main() {
    Parallel().solution(
        arrayOf(
            intArrayOf(1, 4), intArrayOf(9, 2), intArrayOf(3, 8), intArrayOf(11, 6)
        )
    ).also { println(it) } //1

    Parallel().solution(
        arrayOf(
            intArrayOf(3, 5), intArrayOf(4, 1), intArrayOf(2, 4), intArrayOf(5, 10)
        )
    ).also { println(it) } // 0
}

class Parallel {

    fun solution(dots: Array<IntArray>): Int {

        // 6경우 = 12-34, 13-24, 14-23
        val a = dots[0]
        val b = dots[1]
        val c = dots[2]
        val d = dots[3]

        val ab: Double = (b[0] - a[0]).toDouble() / (b[1] - a[1])
        val cd: Double = (c[0] - d[0]).toDouble() / (c[1] - d[1])

        val ac: Double = (a[0] - c[0]).toDouble() / (a[1] - c[1])
        val bd: Double = (b[0] - d[0]).toDouble() / (b[1] - d[1])

        val ad: Double = (d[0] - a[0]).toDouble() / (d[1] - a[1])
        val bc: Double = (c[0] - b[0]).toDouble() / (c[1] - b[1])

        return if (ab == cd || ac == bd || ad == bc) 1
        else 0
    }
}