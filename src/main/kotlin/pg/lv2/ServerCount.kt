package pg.lv2

fun solution(players: IntArray, m: Int, k: Int): Int {
    var answer: Int = 0
    val currentServerList: MutableList<Int> = mutableListOf()

    players.forEach { player ->
        currentServerList.forEachIndexed { index, value ->
            currentServerList[index] = value - 1
        }
        currentServerList.removeAll { it <= 0 }

        if (player >= m && !(currentServerList.size * m <= player && player < (currentServerList.size + 1) * m)) {
            repeat((player / m) - currentServerList.size) {
                currentServerList.add(k)
                answer++
            }
        }
    }
    return answer
}

fun main() {
    val users = intArrayOf(0, 0, 5, 4, 8, 3, 1, 0)
    val m = 3
    val k = 5

    val result = solution(users, m, k)
    println("최소 증설 횟수: $result")  // 예: 4
}
