package backjun.g5

import java.util.*
import java.util.StringTokenizer

import java.io.InputStreamReader

import java.io.BufferedReader
import java.lang.StringBuilder
import java.util.Stack


class P2493 {

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        val st = StringTokenizer(br.readLine())

        val sb = StringBuilder()
        val stack = Stack<IntArray>()
        for (i in 1..n) {
            val top = st.nextToken().toInt()

            while (!stack.isEmpty()) {
                if (stack.peek()[1] >= top) {
                    sb.append(stack.peek()[0].toString() + " ")
                    break
                }
                stack.pop()
            }
            if (stack.isEmpty()) {
                sb.append("0 ")
            }
            stack.push(intArrayOf(i, top))
        }

        println(sb.toString())
    }
}