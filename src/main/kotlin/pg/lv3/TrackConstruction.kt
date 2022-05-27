package pg.lv3

import java.util.*

class TrackConstruction {

    val dx = intArrayOf(0, -1, 0, 1)
    val dy = intArrayOf(1, 0, -1, 0)
    var answer = Integer.MAX_VALUE

    fun solution(board: Array<IntArray>): Int {

        /**
         * 0,0 -> n-1,n-1
         * 0은 빈칸, 1은 벽
         * 직진은 100원 코너는 500원
         */
        val row = board.size
        val col = board[0].size
        val q = LinkedList<DM>()

        q.add(DM(0, 0, -1, 0))
        val visited = Array(row) { Array(col) { BooleanArray (4)  } }
        visited[0][0][0] = true
        visited[0][0][1] = true
        visited[0][0][2] = true
        visited[0][0][3] = true

        val map = board

        while (!q.isEmpty()) {
            val dm = q.poll()

            if (dm.x == row - 1 && dm.y == col - 1) {
                answer = Math.min(answer, dm.cost)
            }

            for (d in 0..3) {
                val nx = dm.x + dx[d]
                val ny = dm.y + dy[d]

                if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue
                if (board[nx][ny] == 1) continue

                val addCost = if (dm.d == -1) 100 else {
                    if (dm.d == d) 100 else 600
                }

                // 25번 테케 여러방향에서 들어오는거 겹치지 않게 처리
                if (!visited[nx][ny][d] || map[nx][ny] >= dm.cost + addCost) {
                    visited[nx][ny][d] = true
                    map[nx][ny] = dm.cost + addCost
                    q.add(DM(nx, ny, d, dm.cost + addCost))
                }
            }
        }

        return answer
    }

    data class DM(val x: Int, val y: Int, val d: Int, val cost: Int)
}