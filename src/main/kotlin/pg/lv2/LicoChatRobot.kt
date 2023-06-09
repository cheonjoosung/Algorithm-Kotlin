package pg.lv2

import java.util.LinkedList
import java.util.Queue

fun main() {
    LicoChatRobot().solution(
        arrayOf("...D..R", ".D.G...", "....D.D", "D....D.", "..D....")
    ).also { println(it) } //7

    LicoChatRobot().solution(
        arrayOf(".D.R", "....", ".G..", "...D")
    ).also { println(it) } //-1
}

class LicoChatRobot {

    fun solution(board: Array<String>): Int {
        var answer: Int = -1

        val row = board.size
        val col = board[0].length

        var sx = 0
        var sy = 0

        var ex = 0
        var ey = 0

        val map = Array(row) { IntArray(col) { 0 } }
        for (i in 0 until row) {
            for (j in 0 until col) {
                map[i][j] = when (board[i][j]) {
                    'D' -> -1
                    'R' -> {
                        sx = i
                        sy = j
                        0
                    }

                    'G' -> {
                        ex = i
                        ey = j
                        0
                    }

                    else -> 0
                }
            }
        }

        val q: Queue<LC> = LinkedList()
        val visit = Array(row) { BooleanArray(col) { false } }
        val dx = intArrayOf(0, -1, 0, 1)
        val dy = intArrayOf(1, 0, -1, 0)

        q.add(LC(sx, sy, 0))
        while (q.isNotEmpty()) {
            val lc = q.poll()

            for (d in 0..3) {
                var nx = lc.x
                var ny = lc.y
                val nc = lc.cnt + 1

                while (true) {
                    nx += dx[d]
                    ny += dy[d]

                    if (nx < 0 || ny < 0 || nx >= row || ny >= col || map[nx][ny] == -1) {
                        nx -= dx[d]
                        ny -= dy[d]
                        break
                    }
                }

                if (visit[nx][ny]) continue

                visit[nx][ny] = true
                if (nx == ex && ny == ey) {
                    answer = nc
                    q.clear()
                } else {
                    q.add(LC(nx, ny, nc))
                }
            }
        }

        return answer
    }
}

data class LC(val x: Int, val y: Int, val cnt: Int)