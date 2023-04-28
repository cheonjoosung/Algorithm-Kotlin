package pg.lv0

import kotlin.math.pow

fun main() {
    solution(7).also { println(it) }
    solution(10).also { println(it) }
}

fun solution(n: Int): Int {
    var answer: Int = 0

    if (n % 2 == 0) {
        for (i in 2..n step 2) {
            answer += i.toDouble().pow(2).toInt()
        }
    } else {
        for (i in 1..n step 2) {
            answer += i
        }
    }

    return answer
}