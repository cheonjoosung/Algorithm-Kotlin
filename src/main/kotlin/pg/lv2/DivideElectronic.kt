package pg.lv2

class DivideElectronic {

    var cnt = 0
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = 100_000_00
        var idx = 0
        while (idx != n) {
            val map = Array(n + 1) { IntArray(n + 1) }

            for (i in wires.indices) { // 제외
                if (idx != i) {
                    map[wires[i][0]][wires[i][1]] = 1
                    map[wires[i][1]][wires[i][0]] = 1
                }
            }

            cnt = 0
            dfs(1, -1, map)
            answer = Math.min(answer, Math.abs((n - cnt) - cnt)) // cnt, (n-cnt) 로 나눠짐
            idx++
        }

        return answer
    }

    private fun dfs(pos: Int, except: Int, map: Array<IntArray>) {
        cnt++

        for (i in map[pos].indices) { //map[pos] -> 다른포지션 가는거 찾는거
            if (i != except && map[pos][i] == 1) {
                dfs(i, pos, map) // 이전 위치는 제외
            }
        }
    }
}