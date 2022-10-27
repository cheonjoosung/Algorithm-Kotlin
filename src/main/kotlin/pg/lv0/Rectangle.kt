package pg.lv0

fun main() {
    val array = arrayOf(intArrayOf(1, 1), intArrayOf(2, 1), intArrayOf(2, 2), intArrayOf(1, 2))
    val array2 = arrayOf(intArrayOf(-1, -1), intArrayOf(1, 1), intArrayOf(1, -1), intArrayOf(-1, 1))
    Rectangle().solution(array).also { println(it) }
    Rectangle().solution(array2).also { println(it) }
}

class Rectangle {

    fun solution(dots: Array<IntArray>): Int {
        var answer: Int = 0

        // 1,1 1,2 2,1 2,2
        dots.sortBy { it[0] }

        val a = Math.abs(dots[0][1] - dots[1][1])
        val b = Math.abs(dots[2][0] - dots[1][0])

        return a * b
    }
}