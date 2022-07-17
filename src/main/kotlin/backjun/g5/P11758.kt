package backjun.g5

import java.util.*

fun main(){

    val sc = Scanner(System.`in`)

    val x1 = sc.nextInt()
    val y1 = sc.nextInt()
    val x2 = sc.nextInt()
    val y2 = sc.nextInt()
    val x3 = sc.nextInt()
    val y3 = sc.nextInt()

    println(ccw(x1, y1, x2, y2, x3, y3))

    sc.close()
}

private fun ccw(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int): Int {
    val a = x1 * y2 + x2 * y3 + x3 * y1
    val b = y1 * x2 + y2 * x3 + y3 * x1

    // 반시계 방향
    return when {
        a - b > 0 -> 1
        a == b ->  0
        else ->  -1
    }
}

