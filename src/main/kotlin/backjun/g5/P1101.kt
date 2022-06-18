package backjun.g5

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val tc = sc.nextInt()
    (1..tc).forEach { _ ->
        val x = sc.nextInt()
        val y = sc.nextInt()

        val distance = y - x // 거리

        val max = Math.sqrt(distance.toDouble()).toInt() // 소수점 버림

        when {
            max.toDouble() == Math.sqrt(distance.toDouble()) -> {
                println(max * 2 - 1)
            }
            distance <= max * max + max -> {
                println(max * 2)
            }
            else -> {
                println(max * 2 + 1)
            }
        }
    }

    sc.close()
}