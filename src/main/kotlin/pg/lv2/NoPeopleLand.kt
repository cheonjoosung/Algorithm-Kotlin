package pg.lv2

import java.util.*

fun main() {
    NoPeopleLand().solution(arrayOf("X591X", "X1X5X", "X231X", "1XXX1")).forEach { print("$it ") }
    println()
    NoPeopleLand().solution(arrayOf("XXX", "XXX", "XXX")).forEach { print("$it ") }
}

class NoPeopleLand {

    fun solution(maps: Array<String>): IntArray {
        val answer = mutableListOf<Int>()

        val arr = Array(maps.size) { IntArray(maps[0].length) { 0 } }

        for (i in maps.indices) {
            val str = maps[i]

            for (j in str.indices) {
                arr[i][j] = if (str[j] == 'X') -1 else str[j].digitToInt()
            }
        }

        val visited = Array(arr.size) { BooleanArray(arr[0].size) { false } }
        val dx = intArrayOf(0, -1, 0, 1)
        val dy = intArrayOf(1, 0, -1, 0)

        for (i in arr.indices) {
            for (j in arr[i].indices) {

                if (visited[i][j] || arr[i][j] == -1) continue

                val q: Queue<Mu> = LinkedList()

                var sum = arr[i][j]
                visited[i][j] = true
                q.add(Mu(i, j))

                while (q.isNotEmpty()) {
                    val mu = q.poll()

                    for (d in 0..3) {
                        val nx = mu.x + dx[d]
                        val ny = mu.y + dy[d]

                        if (nx < 0 || ny < 0 || nx >= arr.size || ny >= arr[0].size) continue
                        if (visited[nx][ny] || arr[nx][ny] == -1) continue

                        sum += arr[nx][ny]
                        visited[nx][ny] = true
                        q.add(Mu(nx, ny))
                    }
                }

                answer.add(sum)
            }

        }

        return if (answer.size == 0) intArrayOf(-1) else answer.sorted().toIntArray()
    }

}

data class Mu(val x: Int, val y: Int)