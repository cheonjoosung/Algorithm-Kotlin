package backjun.s1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs


class P11729 {

    var answer = 0
    var sb = StringBuilder()
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        sb = StringBuilder()

        hanoi(n, 1, 2, 3)

        println(Math.pow(2.0, n.toDouble()).toInt() - 1)
        println(sb)
    }

    private fun hanoi(n: Int, start: Int, via: Int, end: Int) {
        if (n == 1) move(start, end)
        else {
            hanoi(n - 1, start, end, via)
            move(start, end)
            hanoi(n - 1, via, start, end)
        }
    }

    private fun move(start: Int, end: Int) {
        sb.append("$start $end").append("\n")
    }
}
