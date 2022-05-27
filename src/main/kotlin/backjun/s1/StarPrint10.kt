package backjun.s1

import java.lang.StringBuilder
import java.util.*

class StarPrint10 {
    fun main() {
        val sc = Scanner(System.`in`)

        val n = sc.nextInt()

        var arr = Array(n) { CharArray(n) { ' ' } }

        recursion(arr, 0, 0, n)

        var sb = StringBuilder()

        for (temp in arr) {
            for (item in temp)
                sb.append(item)
            sb.append("\n")
        }

        println(sb.toString())

        sc.close()
    }

    private fun recursion(arr: Array<CharArray>, x: Int, y: Int, n: Int) {

        if (n == 1) {
            arr[x][y] = '*'
            return
        }

        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if ((i == 1 && j == 1)) continue

                recursion(arr, x + (i * (n / 3)), y + (j * (n / 3)), n / 3)
            }
        }

        /*
           1,1 일때만 안찍으면 됨
           (0,0) (0,1) (0,2)
           (1,0) (1,1) (1,2)
           (2,0) (2,1) (2,2)
         */
    }
}