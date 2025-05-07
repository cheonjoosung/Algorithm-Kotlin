package pg.lv2

import java.util.LinkedList

class ForkliftAndCrane {
    private lateinit var storage: Array<String>
    private lateinit var visited: Array<IntArray>

    private val moves = arrayOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)

    fun solution(storage: Array<String>, requests: Array<String>): Int {
        this.storage = storage
        this.visited = Array(storage.size + 2) { i ->
            IntArray(storage[0].length + 2) { j ->
                if (i == 0 || j == 0 || i == storage.size + 1 || j == storage[0].length + 1) 1 else 0
            }
        }

        for (request in requests) {
            val nodes = mutableListOf<Pair<Int, Int>>()
            val visitedType = if (request.length == 1) 1 else 2

            for (i in storage.indices) {
                for ((j, c) in storage[i].withIndex()) {
                    if (request[0] != c || visited[i + 1][j + 1] != 0) continue

                    val start = Pair(i + 1, j + 1)
                    if (request.length == 1 && isConnect(start)) {
                        nodes.add(start)
                    } else if (request.length == 2) {
                        nodes.add(start)
                    }
                }
            }

            nodes.forEach { (r, c) -> visited[r][c] = visitedType }

            val q = LinkedList<Pair<Int, Int>>()
            for (i in visited.indices) {
                for ((j, type) in visited[i].withIndex()) {
                    val start = i to j
                    if (type == 2 && isConnect(start)) q.add(start)
                }
            }

            while (q.isNotEmpty()) {
                val (r, c) = q.poll()
                visited[r][c] = 1

                for ((mr, mc) in moves) {
                    val nr = r + mr
                    val nc = c + mc

                    if (nr in visited.indices && nc in visited[0].indices && visited[nr][nc] == 2) {
                        q.offer(nr to nc)
                    }
                }
            }
        }

        return visited.sumOf { arr -> arr.count { it == 0 } }
    }

    private fun isConnect(start: Pair<Int, Int>): Boolean {
        return moves.any { (mr, mc) ->
            val nr = start.first + mr
            val nc = start.second + mc
            nr in visited.indices && nc in visited[0].indices && visited[nr][nc] == 1
        }
    }
}


fun main() {
    ForkliftAndCrane().solution(arrayOf("AZWQY", "CAABX", "BBDDA", "ACACA"), arrayOf("A", "BB", "A")).also { println(it) } //11
    ForkliftAndCrane().solution(arrayOf("HAH", "HBH", "HHH", "HAH", "HBH"), arrayOf("C", "B", "B", "B", "B", "H")).also { println(it) } //4
}