package backjun.g5

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()

    val arr = IntArray(n) { 0 }
    for (i in 0 until n) arr[i] = sc.nextInt()
    arr.sort()

    //-2 4 -99 -1 98
    // -99 -2 -1 4 98
    // -99 -101 -3

    var gap = Int.MAX_VALUE
    var ans1 = 0
    var ans2 = 0

    var i = 0
    var j = arr.size - 1

    while (i < j) {
        val sum = arr[i] + arr[j]

        if (Math.abs(sum) < gap) {
            gap = Math.abs(sum)
            ans1 = arr[i]
            ans2 = arr[j]
        }

        if (sum > 0)
            j--;
        else
            i++;
    }

    println("$ans1 $ans2")
    sc.close()
}