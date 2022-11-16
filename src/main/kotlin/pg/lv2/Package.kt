package pg.lv2

import java.util.*

fun main() {
    //Package().solution(intArrayOf(4, 3, 1, 2, 5)).also { println(it) }
    Package().solution(intArrayOf(5, 4, 3, 2, 1)).also { println(it) }
}

class Package {
    fun solution(order: IntArray): Int {
        var answer: Int = 0

        var idx = 0
        val size = order.size
        val arr = IntArray(size) { it + 1 }
        val saveList = mutableListOf<Int>()

        for (i in arr.indices) {
            if (arr[i] == order[idx]) {
                answer++
                idx++
            } else {
                while (true) {
                    if (saveList.isNotEmpty() && saveList.last() == order[idx]) {
                        answer++
                        idx++
                        saveList.removeLast()
                    } else {
                        break
                    }
                }

                saveList.add(arr[i])
            }
        }

        while (true) {
            if (saveList.isNotEmpty() && saveList.last() == order[idx]) {
                answer++
                idx++
                saveList.removeLast()
            } else {
                break
            }
        }


        return answer
    }
}