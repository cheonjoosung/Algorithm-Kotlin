package backjun.g5

import java.util.*

fun main() {

    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    val list = mutableListOf<Long>()

    when {
        n <= 10 -> println(n)
        n > 1022 -> println(-1)
        else -> {
            for (i in 0 until 10) {
                bp(i.toLong(), 1, list)
            }
            list.sort()
            println(list[n])
        }
    }
}

/**
 * 현재 수 num 이면 num/10 나머지 보다 작은 값만 올수 있음
 * 1 -> 0 = 10
 * 2 -> 1,0 = 21, 20, 210
 * 3 -> 2, 1, 0 = 32, 31, 30, 321, 310
 */
private fun bp(num: Long, idx: Int, list: MutableList<Long>) {
    if (idx > 10) return

    list.add(num)
    for (i in 0 until num % 10) {
        bp(num * 10 + i, idx + 1, list)
    }
}