package backjun.s5

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()

    if (n % 2 == 0) println("CY")
    else println("SK")
    // SK or CY
    // n

    sc.close()
}