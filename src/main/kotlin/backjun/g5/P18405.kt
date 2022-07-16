package backjun.g5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    var split = br.readLine().split(" ")

    val n = split[0].toInt()
    val k = split[1].toInt()
    val arr = Array(n) { IntArray(n) { 0 } }

    for (i in 0 until n) {
        split = br.readLine().split(" ")

        for (j in 0 until n) {
            arr[i][j] = split[j].toInt()
        }
    }

    split = br.readLine().split(" ")
    val t = split[0].toInt()
    val x = split[1].toInt() - 1
    val y = split[2].toInt() - 1

    for (i in 1..t) {
        if (arr[x][y] != 0) break
        else {
            bfs(n, arr)
        }
    }

    println(arr[x][y])
}

val dx = intArrayOf(0, -1, 0, 1)
val dy = intArrayOf(1, 0, -1, 0)
private fun bfs(n: Int, arr: Array<IntArray>) {
    val q: PriorityQueue<P18405> = PriorityQueue()
    val visit = Array(n) { BooleanArray(n) { false } }

    for (i in 0 until n){
        for (j in 0 until n) {
            if (arr[i][j] != 0) {
                visit[i][j] = true
                q.add(P18405(i, j, arr[i][j]))
            }
        }
    }

    while (!q.isEmpty()) {
        val p = q.poll()

        for (d in 0..3) {
            val nx = p.x + dx[d]
            val ny = p.y + dy[d]

            if (nx < 0 || ny < 0 || nx>=n || ny>= n) continue
            if (visit[nx][ny]) continue

            visit[nx][ny] = true
            arr[nx][ny] = p.virus
        }
    }
}

data class P18405(val x: Int, val y: Int, val virus: Int) : Comparable<P18405> {

    override fun compareTo(other: P18405): Int {
        return this.virus - other.virus
    }
}