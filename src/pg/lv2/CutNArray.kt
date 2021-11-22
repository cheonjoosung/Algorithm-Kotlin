package pg.lv2

import java.util.*

class CutNArray {

    fun solution(n: Int, left: Long, right: Long): IntArray {
        val arr = arrayListOf<Int>()

        for (i in left..right) {
            val num = Math.max(i / n, i % n) + 1
            arr.add(num.toInt())
        }

        return arr.toIntArray()
    }
}
