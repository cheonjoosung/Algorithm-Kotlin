package pg.lv2

import java.util.*

fun main() {
    Maze().solution(
        arrayOf("SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE")
    ).also { println(it) } //16

    Maze().solution(
        arrayOf("LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO")
    ).also { println(it) } //-1
}

class Maze {

    private var sx = 0
    private var sy = 0

    private var lx = 0
    private var ly = 0

    private var ex = 0
    private var ey = 0

    private var sToLCount = 0
    private var lToECount = 0

    private val dx = intArrayOf(0, -1, 0, 1)
    private val dy = intArrayOf(1, 0, -1, 0)

    fun solution(maps: Array<String>): Int {
        var answer: Int = -1

        val row = maps.size
        val col = maps[0].length

        val arr = Array(row) { IntArray(col) { 1 } }
        for (i in maps.indices) {
            for (j in maps[i].indices) {
                arr[i][j] = when (maps[i][j]) {
                    'S' -> {
                        sx = i
                        sy = j
                        1
                    }

                    'E' -> {
                        ex = i
                        ey = j
                        1
                    }

                    'L' -> {
                        lx = i
                        ly = j
                        1
                    }

                    'O' -> {
                        1
                    }

                    else -> -1
                }
            }
        }


        /**
         * (sx,sy) -> (lx,ly) 최소
         * (lx,ly) -> (ex,ey) 최소
         */

        var visited = Array(row) { BooleanArray(col) { false } }
        val q: Queue<M> = LinkedList()
        q.add(M(sx, sy, 0))

        var firstAns = -1

        while (q.isNotEmpty()) {
            val m = q.remove()

            for (d in 0..3) {
                val nx = m.x + dx[d]
                val ny = m.y + dy[d]
                val nt = m.t + 1

                if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue
                if (visited[nx][ny]) continue
                if (arr[nx][ny] != 1) continue

                visited[nx][ny] = true
                if (nx == lx && ny == ly) {
                    firstAns = nt
                    q.clear()
                    break
                } else {
                    q.add(M(nx, ny, nt))
                }
            }
        }

        if (firstAns == -1) return -1
        visited = Array(row) { BooleanArray(col) { false } }
        q.add(M(lx, ly, 0))

        var secondAns = -1
        while (q.isNotEmpty()) {
            val m = q.remove()

            for (d in 0..3) {
                val nx = m.x + dx[d]
                val ny = m.y + dy[d]
                val nt = m.t + 1

                if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue
                if (visited[nx][ny]) continue
                if (arr[nx][ny] != 1) continue

                visited[nx][ny] = true
                if (nx == ex && ny == ey) {
                    secondAns = nt
                    q.clear()
                    break
                } else {
                    q.add(M(nx, ny, nt))
                }
            }
        }

        if (secondAns == -1) return -1
        return firstAns+secondAns
    }
}

data class M(
    val x: Int,
    val y: Int,
    val t: Int
)