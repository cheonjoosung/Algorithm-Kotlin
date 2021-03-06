package backjun.s1

import java.util.*

class TreeExit {

    private lateinit var tree: Array<ArrayList<Int>>
    private lateinit var visited: BooleanArray

    var ans = 0
    fun main() {

        val input = System.`in`.bufferedReader()
        val n = input.readLine().toInt()

        tree = Array(n + 1) { ArrayList<Int>() }
        visited = BooleanArray(n + 1) { false }

        for (i in 0 until n - 1) {

            val row = input.readLine().split(" ").map { it.toInt() }

            tree[row[0]].add(row[1])
            tree[row[1]].add(row[0])
        }

        dfs(1, 0)

        if (ans % 2 == 0) println("No")
        else println("Yes")

    }

    private fun dfs(index: Int, cnt: Int) {

        visited[index] = true
        var flag = false

        for (i in tree[index].indices) {

            val node = tree[index][i]

            if (!visited[node]) {
                flag = true
                dfs(node, cnt + 1)
            }


        }

        if (!flag) ans += cnt
    }


}

