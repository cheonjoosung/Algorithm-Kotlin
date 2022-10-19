package pg.lv0

import java.util.*

fun main (){
    OrderFix().solution(intArrayOf(30, 10, 23, 6, 100)).forEach { println("value $it") }
}

class OrderFix {

    fun solution(emergency: IntArray): IntArray {

        return emergency.map {
            emergency.sortedArray().reversedArray().indexOf(it) + 1
        }.toIntArray()
    }
}