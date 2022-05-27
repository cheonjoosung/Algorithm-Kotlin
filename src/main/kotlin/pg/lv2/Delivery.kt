package pg.lv2

class Delivery {

    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        var answer = 0

        val map = Array(N) {
            IntArray(
                N
            )
        }

        for (i in map.indices) {
            for (j in map.indices) {
                if (i == j) {
                    map[i][j] = 0
                    continue
                }
                map[i][j] = 500001
            }
        }

        for (i in road.indices) {
            if (map[road[i][0] - 1][road[i][1] - 1] < road[i][2]) continue
            map[road[i][0] - 1][road[i][1] - 1] = road[i][2]
            map[road[i][1] - 1][road[i][0] - 1] = road[i][2]
        }

        for (k in 0 until N) {
            for (i in 0 until N) {
                for (j in 0 until N) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j]
                    }
                }
            }
        }

        for (i in map.indices)
            if (map[0][i] <= k) answer++

        return answer
    }
}