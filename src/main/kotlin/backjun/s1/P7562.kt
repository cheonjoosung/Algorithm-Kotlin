import java.util.*

fun main() {

    val sc = Scanner(System.`in`)

    val sb = StringBuilder()

    // 나이트의 이동
    val dx = intArrayOf(-1,-2,-2,-1,1,2,2,1)
    val dy = intArrayOf(-2,-1,1,2,2,1,-1,-2)

    val tc = sc.nextInt()

    (1..tc).forEach { _ ->
        val size = sc.nextInt()

        // 시작점, 끝점
        val sx = sc.nextInt()
        val sy = sc.nextInt()

        val ex = sc.nextInt()
        val ey = sc.nextInt()

        val arr = Array(size) { IntArray(size) { -1 } }

        val q: Queue<P7562> = LinkedList()

        q.add(P7562(sx, sy))
        arr[sx][sy] = 0

        while (q.isNotEmpty()) {
            val p = q.poll()

            if (p.x == ex && p.y == ey) break

            for (i in 0..7) {

                val nx = p.x + dx[i]
                val ny = p.y + dy[i]

                if (nx < 0 || ny < 0 || nx >= size || ny >= size) continue

                if (arr[nx][ny] == -1 || arr[p.x][p.y] + 1 < arr[nx][ny]) {
                    arr[nx][ny] = arr[p.x][p.y] + 1
                    q.add(P7562(nx, ny))
                }

            }
        }

        println(arr[ex][ey])

    }
}

data class P7562(val x: Int, val y: Int)