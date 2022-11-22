package pg.lv2

import java.util.HashMap

import java.util.HashSet


fun main() {
    RollCakeCut().solution(intArrayOf(1, 2, 1, 3, 1, 4, 1, 2)).also { println(it) }
    RollCakeCut().solution(intArrayOf(1, 2, 3, 1, 4)).also { println(it) }
}

class RollCakeCut {

    fun solution(topping: IntArray): Int {

        val length: Int = topping.size

        val set: MutableSet<Int> = HashSet()
        val map: MutableMap<Int, Int> = HashMap()

        set.add(topping[0])
        for (i in 1 until length) {
            val number = topping[i]
            map[number] = map.getOrDefault(number, 0) + 1
        }

        var answer = 0

        for (i in 1 until length) {
            val number = topping[i]
            set.add(number)

            val numberSize = map[number]!!

            if (numberSize == 1) {
                map.remove(number)
            } else {
                map[number] = numberSize - 1
            }

            if (set.size == map.size) {
                answer++
            }
        }

        return answer
    }
}
