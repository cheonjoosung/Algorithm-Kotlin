package backjun.s1

import java.io.BufferedReader
import java.io.InputStreamReader


class P2075 {

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()

        val arr = IntArray(n * n) { 0 }

        for (i in 0 until n) {
            val split = br.readLine().split(" ")

            for (j in split.indices) {
                arr[i * n + j] = split[j].toInt()
            }
        }

        arr.sortDescending()
        println(arr[n-1])
    }
}
