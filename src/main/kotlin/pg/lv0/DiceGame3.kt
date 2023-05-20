package pg.lv0

import kotlin.math.abs
import kotlin.math.pow

fun main() {
    DiceGame3().solution(2, 2, 2, 2).also { println(it) }
    DiceGame3().solution(4, 1, 4, 4).also { println(it) }
    DiceGame3().solution(6, 3, 3, 6).also { println(it) }
    DiceGame3().solution(2, 5, 2, 6).also { println(it) }
    DiceGame3().solution(6, 4, 2, 5).also { println(it) }
}

class DiceGame3 {
    fun solution(a: Int, b: Int, c: Int, d: Int): Int {
        var answer: Int = 0

        val set = setOf(a, b, c, d)

        when (set.size) {
            1 -> {
                answer = 1111 * a
            }
            2 -> { //(10*p + q) 제곱
                var p = 0
                var q = 0

                val first = set.first()
                val last = set.last()

                if (a == first) p++ else q++
                if (b == first) p++ else q++
                if (c == first) p++ else q++
                if (d == first) p++ else q++

                answer = if (p > q) {
                    if (p == 3) (10 * first + last).toDouble().pow(2.0).toInt()
                    else (first + last) * (abs(first-last))
                } else {
                    if (q == 3) (10 * last + first).toDouble().pow(2.0).toInt()
                    else (first + last) * (abs(first-last))
                }
            }
            3 -> { //2,5,2,6 다른 두개의 수
                val p = mutableListOf(a,b,c,d).filter { it == set.toIntArray()[0] }.count()
                val q = mutableListOf(a,b,c,d).filter { it == set.toIntArray()[1] }.count()

                answer = when {
                    p == 2 -> {
                        set.toIntArray()[1] * set.toIntArray()[2]
                    }
                    q == 2 -> {
                        set.toIntArray()[0] * set.toIntArray()[2]
                    }
                    else -> {
                        set.toIntArray()[0] * set.toIntArray()[1]
                    }
                }
            }
            4 -> {
                answer = set.minOrNull() ?: 0
            }
        }


        return answer
    }
}