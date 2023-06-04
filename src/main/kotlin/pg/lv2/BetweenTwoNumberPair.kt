package pg.lv2

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

fun main() {
    BetweenTwoNumberPair().solution(2, 3).also { println(it) } //20
}

class BetweenTwoNumberPair {

    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0

        /**
         * 2사분면 기준 * 4
         * ceil/floor 를 이용해 원 사이에 들어가는지 체크
         */
        for (i in 1..r2) {
            val minJ = ceil(sqrt(1.0 * r1 * r1 - 1.0 * i * i)).toLong()
            val maxJ = floor(sqrt(1.0 * r2 * r2 - 1.0 * i * i)).toLong()

            answer += maxJ - minJ + 1
        }

        return answer * 4
    }

}