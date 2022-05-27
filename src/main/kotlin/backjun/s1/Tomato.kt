package backjun.s1

import java.util.*
import java.util.LinkedList

class Tomato {
    fun main() {

        val sc = Scanner(System.`in`)

        val col = sc.nextInt()
        val row = sc.nextInt()
        var answer = 0

        val dx = intArrayOf (0, -1, 0, 1)
        val dy = intArrayOf (1, 0, -1, 0)

        val array: Array<IntArray> = Array(row) { IntArray(col) { 0 } }
        val q: Queue<Pos> = LinkedList()

        for (i in 0 until row) {
            for (j in 0 until col) {
                array[i][j] = sc.nextInt();
                if (array[i][j] == 1) q.add(Pos(i, j))
            }
        }

        while (q.isNotEmpty()) {
            val p = q.poll()

            for (d in 0 until 4) {

                val nx = p.x + dx[d]
                val ny = p.y + dy[d]

                if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue
                if (array[nx][ny] != 0) continue

                q.add(Pos(nx, ny))
                array[nx][ny] = array[p.x][p.y] + 1
            }
        }

        for (i in 0 until row) {
            for (j in 0 until col) {
                if (array[i][j] == 0) {
                    println(-1)
                    return
                } else {
                    answer = Math.max(answer, array[i][j])
                }
            }
        }

        println(answer - 1)
    }

}

data class Pos(val x: Int, val y: Int)