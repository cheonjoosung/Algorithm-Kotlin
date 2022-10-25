package pg.lv0

import java.util.Comparator

import java.util.stream.Collectors

import java.util.stream.IntStream




fun main() {
    SpecialSort().solution(intArrayOf(1, 2, 3, 4, 5, 6), 4).forEach { println(it) }
}

class SpecialSort {

    fun solution(numlist: IntArray, n: Int): IntArray {

        val comparator = Comparator<Int> { o1, o2 ->
            val o1Abs = Math.abs(o1 - n)
            val o2Abs = Math.abs(o2 - n)
            if (o1Abs == o2Abs) {
                if (o1 > o2) return@Comparator -1 else if (o1 < o2) return@Comparator 1
            } else {
                return@Comparator o1Abs - o2Abs
            }
            0
        }

        return numlist.sortedWith(comparator).toIntArray()
    }
}