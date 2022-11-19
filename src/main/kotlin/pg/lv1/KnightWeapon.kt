package pg.lv1

import kotlin.math.sqrt

fun main() {
    KnightWeapon().solution(5, 3, 2).also { println(it) } //10
    KnightWeapon().solution(10, 3, 2).also { println(it) } //21
}

class KnightWeapon {

    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0

        val arr = IntArray(number + 1) { 0 }
        for (i in arr.indices) {
            arr[i] = count(i)
        }

        for (i in arr.indices) {
            if (i == 0) continue
            answer += if (arr[i] > limit) power else arr[i]
        }

        return answer
    }

    private fun count(num: Int):Int {
        var cnt = 0

        val mathNum = sqrt(num.toDouble()).toInt()
        for (i in 1..mathNum) {
            if (i * i == num) cnt++
            else if (num % i == 0) cnt += 2
        }

        return cnt
    }
}