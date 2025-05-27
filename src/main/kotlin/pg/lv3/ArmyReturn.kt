package pg.lv3

import java.util.*

fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): IntArray {
    // 1. 그래프 구성
    val graph = Array(n + 1) { mutableListOf<Int>() }
    for (road in roads) {
        val (a, b) = road
        graph[a].add(b)
        graph[b].add(a)
    }

    // 2. BFS로 destination에서 모든 노드까지의 최단 거리 구하기
    val distance = IntArray(n + 1) { -1 } // -1은 방문하지 않음을 의미
    val queue: Queue<Int> = LinkedList()
    queue.offer(destination)
    distance[destination] = 0

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        for (neighbor in graph[current]) {
            if (distance[neighbor] == -1) {
                distance[neighbor] = distance[current] + 1
                queue.offer(neighbor)
            }
        }
    }

    // 3. sources 배열 기준 결과 추출
    return sources.map { distance[it] }.toIntArray()
}