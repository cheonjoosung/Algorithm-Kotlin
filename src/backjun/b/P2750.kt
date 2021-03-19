package backjun.b

import java.util.*

class P2750 {
    fun main() {
        val sc = Scanner(System.`in`)

        val n = sc.nextInt()
        val arr = IntArray(n)

        for (i in 1..n) {
            arr[i-1] = sc.nextInt()
        }

        arr.sort()

        arr.forEach { println(it) }

        sc.close()
    }

}