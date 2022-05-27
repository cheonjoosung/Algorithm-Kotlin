package pg.lv2

class CheckCoronaDistance {

    fun solution(places: Array<Array<String>>): IntArray {
        val answer = IntArray(places.size) { 0 }

        println(places.size)

        for (i in places.indices) {
            answer[i] = if (check(places[i])) 1 else 0
        }

        return answer
    }

    private fun check(arr: Array<String>): Boolean {

        for (i in arr.indices) {
            for (j in arr[i].indices) {
                if (arr[i][j] == 'P') {
                    if (!isPossible(arr, i, j)) {
                        return false
                    }
                }
            }
        }

        return true
    }

    private fun isPossible(arr: Array<String>, x: Int, y: Int): Boolean {

        val d1 = arrayOf(
            intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1)
        )

        val d2 = arrayOf(
            intArrayOf(2, 0), intArrayOf(1, 1), intArrayOf(0, 2), intArrayOf(-1, 1),
            intArrayOf(-2, 0), intArrayOf(-1, -1), intArrayOf(0, -2), intArrayOf(1, -1)
        )

        for (i in 0..3) {
            val nx = x + d1[i][0]
            val ny = y + d1[i][1]

            if (nx < 0 || ny < 0 || nx >= arr.size || ny >= arr[0].length) continue

            if (arr[nx][ny] == 'P') return false
        }


        for (i in 0..7) {
            val nx = x + d2[i][0]
            val ny = y + d2[i][1]

            if (nx < 0 || ny < 0 || nx >= arr.size || ny >= arr[0].length) continue

            if (arr[nx][ny] == 'P') {
                // 테이블 체크
                if (x == nx) { // 가로
                    val checkY = (y + ny) / 2
                    if (arr[nx][checkY] == 'O' || arr[nx][checkY] == 'P') return false
                } else if (y == ny) { //세로
                    val checkX = (x + nx) / 2
                    if (arr[checkX][ny] == 'O' || arr[checkX][ny] == 'P') return false
                } else { // 대각선
                    if (nx > x || nx < x) if (arr[nx][y] == 'O' || arr[nx][y] == 'P') return false
                    if (ny > y || nx < y) if (arr[x][ny] == 'O' || arr[x][ny] == 'P') return false
                }
            }
        }

        return true
    }
}
