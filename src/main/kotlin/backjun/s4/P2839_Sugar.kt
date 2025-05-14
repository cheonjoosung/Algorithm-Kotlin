package backjun.s4

import java.util.Scanner


fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    var answer = Int.MAX_VALUE

    val div5 = n / 5
    for (i in div5 downTo 0) {
        var temp = 0

        val remain = n-i*5
        if (remain % 3 != 0) {
            continue
        } else {
            temp += i
            temp += remain / 3
        }

        answer = Math.min(answer ,temp)
    }

    if (answer == Int.MAX_VALUE) println(-1)
    else println(answer)

    sc.close()
}