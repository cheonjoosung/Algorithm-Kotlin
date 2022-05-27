package backjun.s1

import java.util.*

class P1456 {

    fun main() {

        val sc = Scanner(System.`in`)

        val a = sc.nextLong()
        val b = sc.nextLong()

        var answer = 0
        val size = Math.sqrt(b.toDouble()).toInt()
        val isNotPrime = BooleanArray(size + 1) { false }

        isNotPrime[0] = true
        isNotPrime[1] = true

        for (i in 2..size) {
            if (isNotPrime[i]) continue

            for (j in 2..size) {
                if (i * j > size) continue
                isNotPrime[i * j] = true
            }
        }

        for (i in Math.sqrt(a.toDouble()).toInt()..size) {
            if (!isNotPrime[i]) {

                var start = i.toLong() * i.toLong()
                while (start in a until b) {
                    answer++
                    start *= i.toLong()
                }
            }
        }

        println(answer)
    }
}