package backjun.s1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs


class P11497 {

    var answer = 0
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val tc = br.readLine().toInt()
        val sb = StringBuilder()

        for (i in 1..tc) {
            val n = br.readLine().toInt()
            val splitArray = br.readLine().split(" ")

            answer = Int.MIN_VALUE

            val pq = PriorityQueue<Int>()

            for (str in splitArray) {
                pq.add(str.toInt())
            }

            val res = IntArray(n) { 0 }
            res[n / 2] = pq.poll()

            var pl = n / 2 - 1
            var pr = n / 2 + 1

            while (pq.isNotEmpty()) {
                if (pr < n) res[pr++] = pq.poll()
                if (pl >= 0) res[pl--] = pq.poll()
            }

            for (i in 1..n)
                answer = answer.coerceAtLeast(abs(res[i % n] - res[i - 1]))

            sb.append(answer).append("\n")
        }

        println(sb)
    }
}
