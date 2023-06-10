package pg.lv2

import kotlin.math.min
import kotlin.math.pow

fun main() {
    Billiard().solution(
        10, 10, 3, 7,
        arrayOf(
            intArrayOf(7, 7), intArrayOf(2, 7), intArrayOf(7, 3)
        )
    ) //[52, 37, 116]
}

class Billiard {

    fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray {
        val answer = IntArray(balls.size)

        for ((idx, arr) in balls.withIndex()) {
            var k = Int.MAX_VALUE

            if (!(startY == arr[1] && startX < arr[0]))
                k = min(k, powExtensions(startY - arr[1]) + powExtensions(2 * m - startX - arr[0]))
            if (!(startY == arr[1] && startX > arr[0]))
                k = min(k, powExtensions(startY - arr[1]) + powExtensions(startX + arr[0]))
            if (!(startX == arr[0] && startY < arr[1]))
                k = min(k, powExtensions(startX - arr[0]) + powExtensions(2 * n - startY - arr[1]))
            if (!(startX == arr[0] && startY > arr[1]))
                k = min(k, powExtensions(startX - arr[0]) + powExtensions(startY + arr[1]))
            answer[idx] = k
        }

        return answer
    }

    private fun powExtensions(v: Int): Int = (v.toDouble()).pow(2).toInt()
}
