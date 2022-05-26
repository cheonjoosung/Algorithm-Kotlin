package backjun.s2

import java.lang.StringBuilder
import java.util.*

class P4948 {

    fun main() {
        val sc = Scanner(System.`in`)

        val max = 123_456 * 2
        val isNotPrime = BooleanArray(max + 1) { false }

        isNotPrime[0] = true
        isNotPrime[1] = true

        val sb = StringBuilder()

        for (i in 2..max) {
            if (isNotPrime[i]) continue

            for (j in 2 until max) {
                if (j * i > max) break
                isNotPrime[i * j] = true
            }
        }

        while (true) {
            val num = sc.nextInt()
            if (num == 0) break

            var cnt = 0
            for (i in num + 1..2 * num) {
                if (i > max) continue
                if (!isNotPrime[i]) cnt++
            }

            sb.append(cnt).append("\n")
        }

        println(sb.toString())

        sc.close()
    }
}