package pg.lv3

fun main() {

    val a1 = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))
    val a2 = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 1))

    val network = Network()

    println(network.solution(3, a1))
    println(network.solution(3, a2))
}

class Network {

    private val disconnected = mutableListOf<Int>()

    fun solution(n: Int, computers: Array<IntArray>): Int {

        var answer = 0

        for (i in 0 until n) disconnected.add(i)

        while (disconnected.size > 0) {
            answer++
            dfs(n, computers, disconnected.removeAt(0))
        }

        return answer
    }

    private fun dfs(n: Int, computers: Array<IntArray>, computer: Int) {

        for (i in 0 until n) {
            // 두 컴퓨터가 연결되어 있는 경우
            if (disconnected.contains(i) && computers[computer][i] == 1) {
                // 네트워크에 속한 컴퓨터 제거
                disconnected.remove(i)
                dfs(n, computers, i)
            }
        }
    }
}