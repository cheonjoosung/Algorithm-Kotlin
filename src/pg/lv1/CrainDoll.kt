package pg.lv1

class CrainDoll {
    fun solution(board2: Array<IntArray>, moves: IntArray): Int {
        var answer = 0

        val board: Array<Array<Int>> = arrayOf(
            arrayOf(0, 0, 0, 0, 0),
            arrayOf(0, 0, 1, 0, 3),
            arrayOf(0, 2, 5, 0, 1),
            arrayOf(4, 2, 4, 4, 2),
            arrayOf(3, 5, 1, 3, 1)
        )

        var n = board[0].size
        var temp = Array(n) { IntArray(n) }

        /* 기존
            0, 0, 0, 0, 0,
            0, 0, 1, 0, 3,
            0, 2, 5, 0, 1,
            4, 2, 4, 4, 2,
            3, 5, 1, 3, 1

         */
        for (i in 0 until n) {
            for (j in 0 until n) {
                temp[i][j] = board[j][i]
            }
        }

        /* 변환
            0 0 0 4 3
            0 0 2 2 5
            0 1 5 4 1
            0 0 0 4 3
            0 3 1 2 1
         */

        var arr = mutableListOf<Int>()

        for (i in moves) {
            val pos = i - 1

            val res = temp[pos].firstOrNull { it != 0 }

            if (res != null) {
                val jIdx = temp[pos].indexOf(res)
                temp[pos][jIdx] = 0

                if (arr.isEmpty()) {
                    arr.add(res)
                } else {
                    if (arr.last() == res) {
                        answer += 2
                        arr.removeAt(arr.size - 1)
                    } else {
                        arr.add(res)
                    }
                }
            }
        }

        return answer
    }
}