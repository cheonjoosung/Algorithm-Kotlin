package backjun.g3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class Panda {
    val dx = arrayOf(0, -1, 0, 1)
    val dy = arrayOf(1, 0, -1, 0)
    var N = 0

    lateinit var map: Array<IntArray>
    lateinit var dp: Array<IntArray>

    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        N = br.readLine().toInt()

        map = Array(N) { IntArray(N) }
        dp = Array(N) { IntArray(N) }


        for (i in 0 until N) {
            val st = StringTokenizer(br.readLine())

            for (j in 0 until N) {
                map[i][j] = st.nextToken().toInt()
            }
        }

        var ans = 0
        for (i in 0 until N) {
            for (j in 0 until N) {
                ans = Math.max(ans, dfs(i,j))
            }
        }

        println(ans)
        br.close()
    }

    fun dfs(x: Int, y: Int): Int {
        if (dp[x][y] != 0) return dp[x][y]

        dp[x][y] = 1

        for (d in 0..3) {
            var nx = x + dx[d]
            var ny = y + dy[d]

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue

            if (map[x][y] < map[nx][ny]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny)+1)
            }
        }

        return dp[x][y]
    }
}