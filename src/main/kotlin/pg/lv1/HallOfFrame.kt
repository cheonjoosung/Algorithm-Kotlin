package pg.lv1

import java.util.*

fun main() {

    HallOfFrame().solution(3, intArrayOf(10, 100, 20, 150, 1, 100, 200)).forEach { print("$it ") }
    //[10, 10, 10, 20, 20, 100, 100]
    println()
    //HallOfFrame().solution(4, intArrayOf(0, 300, 40, 300, 20, 70, 150, 50, 500, 1000)).forEach { print("$it ") }
    //[0, 0, 0, 0, 20, 40, 70, 70, 150, 300]
}

class HallOfFrame {

    fun solution(k: Int, score: IntArray): IntArray {
        val answer = IntArray(score.size) { 0 }

        val list = mutableListOf<Int>()

        for (i in score.indices) {
            list.add(score[i])
            list.sortDescending()

            answer[i] = if (i < k - 1){
                list.last()
            } else {
                list[k - 1]
            }
        }

        return answer
    }
}