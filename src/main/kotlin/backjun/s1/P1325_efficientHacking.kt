package backjun.s1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {

    /**
     * 5 4
     * 3 1
     * 3 2
     * 4 3
     * 5 3
     */
    // A가 B 신뢰시 B해킹 시 A도 가능
    // n <= 10,000, m<=100,000 1 번부터 N 번까지의 숫자가 있다
    // 한번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력 오름차순

    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(n + 1) { mutableListOf<Int>() }
    val result = IntArray(n + 1)

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        // b 해킹 시 a 해킹 가능하므로 역방향
        graph[b].add(a)
    }

    for (i in 1..n) {
        val visited = BooleanArray(n + 1)
        val q: Queue<Int> = LinkedList()

        visited[i] = true
        q.add(i)

        while (q.isNotEmpty()) {
            val current = q.poll()

            for (next in graph[current]) {
                if (!visited[next]) {
                    visited[next] = true
                    result[i]++
                    q.add(next)
                }
            }
        }
    }

    val max = result.maxOrNull() ?: 0
    val answer = StringBuilder()
    for (i in 1..n) {
        if (result[i] == max) {
            answer.append("$i ")
        }
    }

    println(answer.toString().trim())
}