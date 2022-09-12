package pg.lv2

class LightPassCycle {

    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(-1, 0, 1, 0)

    fun solution(grid: Array<String>): IntArray {
        val answer = mutableListOf<Int>()

        val visit = Array(grid.size) {
            Array(grid[it].length) { BooleanArray(4) }
        }

        for (i in visit.indices) {
            for (j in visit[i].indices) {
                for (d in visit[i][j].indices) {
                    if (!visit[i][j][d]) answer.add(getLightLen(grid, visit, j, i, d))
                }
            }
        }

        return answer.sorted().toIntArray()
    }

    private fun getLightLen(
        grid: Array<String>,
        visit: Array<Array<BooleanArray>>,
        j: Int,
        i: Int,
        direction: Int
    ): Int {

        var cnt = 0
        var x = j
        var y = i
        var d = direction

        while (!visit[y][x][d]) {
            cnt++
            visit[y][x][d] = true   // 현재 노드의 현재 방향 방문처리

            when (grid[y][x]) {
                'L' -> d = (d - 1 + 4) % 4  // 방향 반시계방향 회전
                'R' -> d = (d + 1) % 4  // 방향 시계방향 회전
            }

            // 다음 방문할 위치계산 (중간에 배열의 크기를 더해서 음수가 되는것을 방지)
            x = (x + dx[d] + grid[0].length) % grid[0].length
            y = (y + dy[d] + grid.size) % grid.size
        }

        return cnt
    }
}