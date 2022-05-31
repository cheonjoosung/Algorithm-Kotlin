import java.util.*

fun main() {

    val scan = Scanner(System.`in`)

    val sb = StringBuilder()

    val dx = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)
    val dy = intArrayOf(1, 1, 0, -1, -1, -1, 0, 1)

    while (true) {
        val col = scan.nextInt()
        val row = scan.nextInt()

        if (row == 0 || col == 0) break

        var cnt = 0

        val arr = Array(row) { IntArray(col) { 0 } }
        val visit = Array(row) { BooleanArray(col) { false } }

        for (i in 0 until row) {
            for (j in 0 until col) {
                arr[i][j] = scan.nextInt()
            }
        }

        for (i in 0 until row) {
            for (j in 0 until col) {
                if (arr[i][j] == 0 || visit[i][j]) continue

                visit[i][j] = true

                val q: Queue<Pos> = LinkedList()
                q.add(Pos(i, j))

                while (!q.isEmpty()) {
                    val pos = q.poll()

                    for (d in 0 until 8) {
                        val nx = pos.x + dx[d]
                        val ny = pos.y + dy[d]

                        if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue
                        if (visit[nx][ny] || arr[nx][ny] == 0) continue

                        visit[nx][ny] = true
                        q.add(Pos(nx, ny))
                    }
                }

                cnt++
            }
        }
        sb.append(cnt).append("\n")
    }

    println(sb.toString())
}

data class Pos(val x: Int, val y: Int)