package etc

import java.util.*

class Train {

    fun main() {
        /*
        n/passenger/train/return
6/[1,1,1,1,1,1]/[[1,2],[1,3],[1,4],[3,5],[3,6]]/[6,3]
4/[2,1,2,2]/[[1,2],[1,3],[2,4]]/[4,5]
5/[1,1,2,3,4]/[[1,2],[1,3],[1,4],[1,5]]/[5,5]
         */

        val move: Array<IntArray> = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 4),
            intArrayOf(3, 5),
            intArrayOf(3, 6)
        )
        val move2: Array<IntArray> = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 4)
        )
        val move3: Array<IntArray> = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 4),
            intArrayOf(1, 5)
        )
        val arr = intArrayOf(1, 1, 1, 1, 1, 1)
        val arr2 = intArrayOf(2, 1, 2, 2)
        val arr3 = intArrayOf(1, 1, 2, 3, 4)

        println(solve(6, arr, move))
        println(solve(4, arr2, move2))
        println(solve(5, arr3, move3))
    }

    fun solve(n: Int, passenger: IntArray, move: Array<IntArray>) {

        var tree = Array(n + 1) { ArrayList<Int>() }
        var visited = BooleanArray(n + 1) { false }
        var arr = IntArray(n + 1) { 0 }

        for (i in 1..n) {
            arr[i] = passenger[i-1]
        }

        for (i in move.indices) {
            val s = move[i][0]
            val e = move[i][1]

            tree[s].add(e)
            println("$s $e")
        }

        var q: Queue<Int> = LinkedList()
        q.add(1)
        visited[1] = true

        while (!q.isEmpty()) {

            val base = q.poll()

            for (i in 0 until tree[base].size) {

                val next = tree[base].get(i)

                arr[next] = Math.max(arr[next], arr[base] + passenger[next - 1])
                if (!visited[next]) {
                    q.add(next)
                    visited[next] = true
                }
            }
        }

        for (i in arr) {
            print("$i ")
        }
    }
}