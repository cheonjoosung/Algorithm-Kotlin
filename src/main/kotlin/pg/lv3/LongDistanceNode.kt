package pg.lv3

import java.util.*


fun main() {
    LongDistanceNode().solution(
        6,
        arrayOf(
            intArrayOf(3, 6),
            intArrayOf(4, 3),
            intArrayOf(3, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 2),
            intArrayOf(2, 4),
            intArrayOf(5, 2)
        )
    ).also { println(it) } //3
}

class LongDistanceNode {

    var array: Array<ArrayList<Int>> = arrayOf()
    var visited: BooleanArray = booleanArrayOf();
    var dist: IntArray = intArrayOf()
    var size = 0

    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0

        size = n
        array = Array(n + 1) { ArrayList() }
        dist = IntArray(n + 1) { 0 }
        visited = BooleanArray(n + 1)

        for (i in edge.indices) {
            array[edge[i][0]].add(edge[i][1])
            array[edge[i][1]].add(edge[i][0])
        }

        bfs()
        dist.sortDescending()

        val max = dist[0]

        for (i in dist.indices) {
            if (max == dist[i]) {
                answer++
            } else {
                break
            }
        }


        return answer
    }

    private fun bfs() {

        val list: LinkedList<Int> = LinkedList()

        visited[1] = true
        list.add(1)
        dist[1] = 1

        while (list.isNotEmpty()) {
            val now = list.poll()
            for (i in array[now].indices) {

                val num = array[now][i]

                if (!visited[num]) {
                    visited[num] = true
                    dist[num] = dist[now] + 1
                    list.add(num)
                }
            }

        }

    }
}