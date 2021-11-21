package pg.lv2

import java.util.*

class CutNArray {

    fun solution(n: Int, left: Long, right: Long): IntArray {

        val arr = Array(n) { IntArray(n) { 0 } }
        val d = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(1, 1))

        arr[0][0] = 1

        val q = LinkedList<Pos>()
        q.add(Pos(0, 0, 1))

        while (!q.isEmpty()) {

            val p = q.poll()

            for (i in 0..2) {
                val nx = p.x + d[i][0]
                val ny = p.y + d[i][1]

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue
                if (arr[nx][ny] != 0) continue

                arr[nx][ny] = p.value + 1
                q.add(Pos(nx, ny, p.value + 1))
            }
        }

        for (i in arr.indices) {
            for (j in arr[i].indices) {
                print("${arr[i][j]} ")
            }
            println()
        }

        val list = mutableListOf<Int>()
        for (temp in arr) list.addAll(temp.toMutableList())

        return list.subList(left.toInt(), right.toInt()+1).toIntArray()
    }

    data class Pos(val x: Int, val y: Int, val value: Int)
}
