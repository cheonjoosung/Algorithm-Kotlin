package pg.lv2

import java.lang.Math.pow
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    //DrawPoint().solution(2, 4).also { println(it) } //6
    DrawPoint().solution(1, 5).also { println(it) } //26
}

class DrawPoint {

    fun solution(k: Int, d: Int): Long {
        var answer: Long = 0

        for (i in 0..(d/k)) {
            val longX = i*k
            val longY = (sqrt(d.toDouble().pow(2.0) - longX.toDouble().pow(2.0)) / k).toLong()

            answer += longY + 1L // 0도 포함해주어야 하므로 +1
        }

        return answer
    }

    fun solution2(k: Int, d: Int): Long {
        var answer: Long = 0

        for (i in 0..(d/k)) {
            val longX = i*k
            for (j in 0..(d/k)) {
                val longY = j*k

                if (sqrt(longX.toDouble().pow(2.0) + longY.toDouble().pow(2.0)) <= d) {
                    answer++
                }
            }
        }

        return answer
    }
}