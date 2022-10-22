package pg.lv0

import java.math.BigInteger

fun main() {
    BallDivideNumberCase().solution(3, 2).also { println(it) }
    BallDivideNumberCase().solution(5, 3).also { println(it) }
}

class BallDivideNumberCase {

    fun solution(balls: Int, share: Int): Int {

        val factorial = LongArray(balls + 1) { 1 }

        for (i in 2..balls) {
            factorial[i] = i * factorial[i - 1]
        }

        //return (factorial[balls] / ((factorial[balls - share]) * factorial[share])).toInt()
        return (fact(balls) / ((fact(balls - share) * fact(share)))).toInt()
    }

    private fun fact(num: Int): BigInteger {
        var returnNumber = BigInteger.ONE

        for (i in 2..num) {
            returnNumber *= BigInteger.valueOf(i.toLong())
        }

        return returnNumber
    }
}