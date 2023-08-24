package structure

import java.util.*

class Dijkstra {

    fun dijkstra() {
        val sc = Scanner(System.`in`)

        val n = sc.nextInt()
        val m = sc.nextInt()

        val start = sc.nextInt()
        val end = sc.nextInt()

        val graph = Array(n) { mutableListOf<Pair<Int, Int>>() } // 노드 연결 정보
        val distance = (0..n).map { Int.MAX_VALUE }.toMutableList() // 최단 거리 테이블

        repeat(m) {
            val s = sc.nextInt()
            val e = sc.nextInt()
            val c = sc.nextInt()

            graph[s].add(Pair(e, c))
        }

        val q = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
            when {
                p1.second > p2.second -> 1
                p1.second < p2.second -> -1
                else -> 0
            }
        }

        q.add(Pair(start, 0))
        distance[start] = 0

        val answer = mutableListOf<Int>()

        while (q.isNotEmpty()) {
            val (now, dist) = q.poll() // 최단 거리가 가장 짧은 정보 꺼내기
            if (distance[now] < dist) continue

            for (i in graph[now]) {
                val cost = dist + i.second

                if (i.first == end) {
                    answer.add(cost)
                }
                if (cost < distance[i.first]) {
                    distance[i.first] = cost
                    q.add(Pair(i.first, cost))
                }
            }
        }

        if (answer.size <= 1) println(-1) else println(answer[1])
    }


}