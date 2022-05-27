package pg.lv1

import java.util.*

class FindDivideRemainOne {

    fun solution(n: Int): Int {
        var answer: Int = 0

        for (i in 1..n) {
            if (n % i == 1) {
                answer = i
                break
            }
        }
        return answer
    }
}