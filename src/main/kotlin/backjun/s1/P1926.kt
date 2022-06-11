import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
var m:Int = 0
var answer:Int = 0
var temp_square:Int = 0
lateinit var map: Array<IntArray>
lateinit var visit: Array<IntArray>

var dx = intArrayOf(0, 1, 0, -1)
var dy = intArrayOf(1, 0, -1, 0)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    map = Array(n) { IntArray(m) }
    visit = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until m) {
            map[i][j] = st.nextToken().toInt()
        }
    }

    var picture_cnt = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (visit[i][j] == 0 && map[i][j] == 1) {
                visit[i][j] = 1
                temp_square = 1
                dfs2(i, j)
                picture_cnt++
            }
        }
    }

    println(picture_cnt)
    println(answer)
}

fun dfs2(idx: Int, jdx: Int) {
    if (answer < temp_square) answer = temp_square

    for (i in 0..3) {
        val nx: Int = idx + dx[i]
        val ny: Int = jdx + dy[i]
        if (nx < 0 || ny < 0 || nx >= n || ny >= m || visit[nx][ny] == 1 || map[nx][ny] == 0) continue
        temp_square++
        visit[nx][ny] = 1
        dfs2(nx, ny)
    }
}