package pg.lv1

import java.util.*

class MinimumRectangular {

    fun solution(sizes: Array<IntArray>): Int {

        var a = 0
        var b = 0

        for (arr in sizes) {
            Arrays.sort(arr)

            a = Math.max(a, arr[0])
            b = Math.max(b, arr[1])
        }

        return a*b
    }
}