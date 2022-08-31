package pg.lv2

import java.util.*

fun main() {

    val q1 = intArrayOf(3, 2, 7, 2)
    val q2 = intArrayOf(4, 6, 5, 1)

    val q3 = intArrayOf(1, 2, 1, 2)
    val q4 = intArrayOf(1, 10, 1, 2)

    val q5 = intArrayOf(1, 1)
    val q6 = intArrayOf(1, 5)

    println(solution(q1, q2)) //2
    println(solution(q3, q4)) //7
    println(solution(q5, q6)) //-1
}

fun solution(queue1: IntArray, queue2: IntArray): Int {

    val q1: Queue<Int> = java.util.ArrayDeque<Int>()
    val q2: Queue<Int> = java.util.ArrayDeque<Int>()
    var s1: Long = 0
    var s2: Long = 0
    var sum: Long = 0

    for (tmp in queue1) {
        q1.add(tmp)
        s1 += tmp.toLong()
    }
    for (tmp in queue2) {
        q2.add(tmp)
        s2 += tmp.toLong()
    }
    sum = s1 + s2
    if (sum % 2 == 1L) return -1
    sum /= 2

    var p1 = 0
    var p2 = 0
    val limit: Int = queue1.size * 2

    while (p1 <= limit && p2 <= limit) {
        if (s1 == sum) return p1 + p2
        if (s1 > sum) {
            s1 -= q1.peek()
            s2 += q1.peek()
            q2.add(q1.poll())
            p1++
        } else {
            s2 -= q2.peek()
            s1 += q2.peek()
            q1.add(q2.poll())
            p2++
        }
    }

    return -1
}