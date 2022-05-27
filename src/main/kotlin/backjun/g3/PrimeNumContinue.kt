package backjun.g3

import java.util.*

class PrimeNumContinue {
    fun main() {
        /*
        20 3 41 53 -> 0 1 3 2
        3 : 3 (한 가지)
        41 : 2+3+5+7+11+13 = 11+13+17 = 41 (세 가지)
        53 : 5+7+11+13+17 = 53 (두 가지)
         */
        val sc = Scanner(System.`in`)

        val n = sc.nextInt()

        var answer = 0
        var isNotPrime = BooleanArray(n+1)
        var list = isNotPrimeNumber(n, isNotPrime)

        for (i in 0 until list.size) {
            var sum = list[i]

            for (j in i until list.size) {
                if (i != j)
                    sum += list[j]


                if (sum == n) {
                    answer++
                    break
                } else if(sum > n) {
                    break
                }
            }
        }

        println(answer)
        sc.close()
    }

    private fun isNotPrimeNumber(n: Int, isNotPrime: BooleanArray): MutableList<Int> { //배수 활용
        isNotPrime[0] = true
        isNotPrime[1] = true

        for (i in 2..n) {
            if (isNotPrime[i]) continue

            for (j in 2 until n) {
                if (j*i > n) break
                isNotPrime[i * j] = true
            }
        }

        var list = mutableListOf<Int>()
        isNotPrime.mapIndexed{ index, b -> if(!b) list.add(index) }

        return list
    }
}