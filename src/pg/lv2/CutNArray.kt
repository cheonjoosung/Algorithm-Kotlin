package pg.lv2

import java.util.ArrayList
import java.util.HashMap

class CandidateKey {

    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer: IntArray = intArrayOf()

        var arr = Array(n) { IntArray(n) { 0 } }
        var visited = Array(n) { BooleanArray(n) { false } }

        visited[0][0] = true
        arr[0][0] = 1

        var q = java.util.Queue<Pos>
        q.add(Pos(0, 0, 1))

        while (q.isEmpty()) {

        }

        return answer
    }

    private fun bfs(n: Int, array: Array<IntArray>, visited: Array<BooleanArray>) {


    }

    data class Pos(val x: Int, val y: Int, value: Int)
}
