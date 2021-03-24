package backjun.b

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

class P2751 {
    fun main() {
        /*val sc = Scanner(System.`in`)

        val n = sc.nextInt()*/

        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val arr = ArrayList<Int>()

        for (i in 1..n) {
            arr.add(br.readLine().toInt())
        }

        arr.sort()

        val sb = StringBuilder()
        for (value in arr) {
            sb.append(value).append("\n")
        }

        println(sb.toString())
    }

}