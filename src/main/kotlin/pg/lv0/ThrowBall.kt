package pg.lv0

fun main() {

    ThrowBall().solution(intArrayOf(1, 2, 3, 4), 2).run { println(this) }
    ThrowBall().solution(intArrayOf(1, 2, 3, 4, 5, 6), 5).run { println(this) }
    ThrowBall().solution(intArrayOf(1, 2, 3), 3).run { println(this) }
}
class ThrowBall {

    fun solution(numbers: IntArray, k: Int): Int {
        return numbers[(2*(k-1) + numbers.size) % numbers.size]
    }
}