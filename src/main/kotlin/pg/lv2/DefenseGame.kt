package pg.lv2

import java.util.*




fun main() {
    DefenseGame().solution(7, 3, intArrayOf(4, 2, 4, 5, 3, 3, 1)).also { println(it) } //5
    DefenseGame().solution(2, 4, intArrayOf(3, 3, 3, 3)).also { println(it) } //4
}

class DefenseGame {

    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var answer: Int = enemy.size

        val pq = PriorityQueue<Int>(Collections.reverseOrder())

        var my = n
        var card = k

        for (i in enemy.indices) {
            my -= enemy[i]
            pq.add(enemy[i])

            if (my < 0) {
                if (card > 0 && !pq.isEmpty()) {
                    my += pq.poll()
                    card--
                } else {
                    answer = i
                    break
                }
            }
        }

        return answer
    }
}