package backjun.s1

import java.util.*
import kotlin.math.abs

class P9020 {

    fun main() {

        val sc = Scanner(System.`in`)

        val tc = sc.nextInt()

        val isNotPrime = BooleanArray(10_000 + 1) { false }
        checkIsNotPriem(isNotPrime)

        for (i in 1..tc) {
            val evenNum = sc.nextInt()

            var n1 = 0
            var n2 = 0
            var min = Int.MAX_VALUE

            for (j in 1 until evenNum) {
                if (!isNotPrime[j] && !isNotPrime[evenNum - j]) {

                    val diff = abs(2 * j - evenNum)
                    if (min > diff) {
                        min = diff
                        n1 = j.coerceAtMost(evenNum - j)
                        n2 = j.coerceAtLeast(evenNum - j)
                    }
                }
            }

            println("$n1 $n2")
        }

        sc.close()
    }

    private fun checkIsNotPriem(isNotPrime: BooleanArray) {
        isNotPrime[0] = true
        isNotPrime[1] = true

        for (i in 2..10_000) {
            if (isNotPrime[i]) continue

            for (j in 2..10_000) {
                if (i * j > 10_000) continue
                isNotPrime[i * j] = true
            }
        }
    }

}