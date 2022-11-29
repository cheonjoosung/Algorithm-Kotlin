package pg.lv2

import java.util.ArrayList




class OrangeChoice {

    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0

        val map = hashMapOf<Int, Int>()

        for (i in tangerine) {
            map[i] = map.getOrDefault(i, 0) + 1
        }

        val list = ArrayList(map.keys)
        list.sortWith(Comparator { o1, o2 -> map[o2]!! - map[o1]!! })

        var ans = k
        for (x in list) {
            ans -= map[x]!!
            answer++
            if (ans <= 0) break
        }

        return answer
    }
}