package pg.lv2

import java.lang.Integer.max
import java.lang.Integer.min
import java.lang.StringBuilder

fun main() {

    val array = arrayOf(
        intArrayOf(2, -1, 4), intArrayOf(-2, -1, 4),
        intArrayOf(0, -1, 1), intArrayOf(5, -8, -12), intArrayOf(5, 8, 12)
    )
    //["....*....", ".........", ".........", "*.......*", ".........", ".........", ".........", ".........", "*.......*"]
    val array2 = arrayOf(
        intArrayOf(0, 1, -1), intArrayOf(1, 0, -1),
        intArrayOf(1, 0, 1)
    )
    //["*.*"]
    val array3 = arrayOf(intArrayOf(1, -1, 0), intArrayOf(2, -1, 0))
    //["*"]
    val array4 = arrayOf(
        intArrayOf(1, -1, 0), intArrayOf(2, -1, 0),
        intArrayOf(4, -1, 0)
    )
    //["*"]

    println(solution(array))
}

fun solution(line: Array<IntArray>): Array<String> {
    val intersectionPoints = initSet(line)
    val (minX, minY, maxX, maxY) = getMinMax(intersectionPoints)
    val array = Array((maxY + 1 - minY)) { Array((maxX + 1 - minX)) { "." } }

    for ((x, y) in intersectionPoints) {
        array[(maxY - y).toInt()][(x - minX).toInt()] = "*"
    }
    return array.map { it.joinToString("") }.toTypedArray()
}

private fun getMinMax(intersectionPoints: Set<Pair<Long, Long>>): Array<Int> {
    val result = arrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MIN_VALUE, Int.MIN_VALUE)

    for ((x, y) in intersectionPoints) {
        result[0] = min(result[0], x.toInt())
        result[1] = min(result[1], y.toInt())
        result[2] = max(result[2], x.toInt())
        result[3] = max(result[3], y.toInt())
    }
    return result
}

private fun initSet(line: Array<IntArray>): Set<Pair<Long, Long>> {
    val mutableSet = mutableSetOf<Pair<Long, Long>>()

    for (i in line.indices) {
        for (j in i + 1 until line.size) {
            val (a, b, e) = line[i].map { it.toLong() }
            val (c, d, f) = line[j].map { it.toLong() }
            val div = a * d - b * c
            val topX = b * f - e * d
            val topY = e * c - a * f

            if (div == 0L) {
                continue
            } else {
                val x = topX / div
                val y = topY / div

                if (topX % div != 0L || topY % div != 0L)
                    continue
                mutableSet.add(x to y)
            }
        }
    }
    return mutableSet
}