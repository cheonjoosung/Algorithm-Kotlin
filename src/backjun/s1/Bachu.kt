package backjun.s1

class Bachu {

    fun main() {

        val br = System.`in`.bufferedReader()

        val tc = br.readLine().toInt()

        var ans = IntArray(tc) { 0 }

        for (i in 1..tc) {

            var input = br.readLine().split(" ")

            val col = input[0].toInt()
            val row = input[1].toInt()
            val cnt = input[2].toInt()

            var map = Array(row) { IntArray(col) { 0 } }
            var visited = Array(row) { BooleanArray(col) { false } }

            var bachu = 0

            for (j in 1..cnt) {

                input = br.readLine().split(" ")

                val y = input[0].toInt()
                val x = input[1].toInt()

                map[x][y] = 1
            }


            for (i in map.indices) {
                for (j in map[i].indices) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true

                        dfs(i, j, visited, map, row, col)
                        bachu++
                    }
                }
            }

            ans[i-1] = bachu

        }

        for (i in ans)
            println(i)
    }

    val dx = intArrayOf(0, -1, 0, 1)
    val dy = intArrayOf(1, 0, -1, 0)

    private fun dfs(x: Int, y: Int, visited: Array<BooleanArray>, map: Array<IntArray>, row: Int, col: Int) {

        for (d in 0..3) {
            val nx = x + dx[d]
            val ny = y + dy[d]

            if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue
            if (visited[nx][ny]) continue
            if (map[nx][ny] == 0) continue

            visited[nx][ny] = true
            dfs(nx, ny, visited, map, row, col)
        }

        return
    }
}