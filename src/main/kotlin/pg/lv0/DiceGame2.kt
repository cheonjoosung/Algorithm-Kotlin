package pg.lv0

fun main() {
    //DiceGame2().solution(2, 6, 1).also { println(it) }
    DiceGame2().solution(5, 3, 3).also { println(it) }
    DiceGame2().solution(4, 4, 4).also { println(it) }
}

class DiceGame2 {
    fun solution(a: Int, b: Int, c: Int): Int {

        val sum = a + b + c
        val sum2 = (Math.pow(a.toDouble(), 2.0) + Math.pow(b.toDouble(), 2.0) + Math.pow(c.toDouble(), 2.0)).toInt()
        val sum3 = (Math.pow(a.toDouble(), 3.0) + Math.pow(b.toDouble(), 3.0) + Math.pow(c.toDouble(), 3.0)).toInt()

        return if (a != b && b != c && a != c) {
            sum
        } else if (a == b && b == c) {
            sum * sum2 * sum3
        } else {
            sum * sum2
        }
    }
}