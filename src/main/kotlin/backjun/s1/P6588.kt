package backjun.s1

import java.io.BufferedReader
import java.io.InputStreamReader

class P6588 {

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val isNotPrime = BooleanArray(1_000_000 + 1) { false }

        for (i in 2..1_000_000) {
            if (isNotPrime[i]) continue

            var j = i * 2
            while (j <= 1_000_000) {
                isNotPrime[j] = true
                j += i
            }
        }

        val sb = StringBuilder()

        while (true) {
            val number = br.readLine().toInt()
            var isExists = false
            if (number == 0) {
                println(sb)
                return
            }
            var i = 3
            while (i <= number) {
                if (!isNotPrime[i] && !isNotPrime[number - i]) {
                    sb.append(number.toString() + " = " + i + " + " + (number - i)).append("\n")
                    isExists = true
                    break
                }
                i += 2
            }
            if (!isExists) {
                sb.append("Goldbach's conjecture is wrong.").append("\n")
            }
        }
    }

}