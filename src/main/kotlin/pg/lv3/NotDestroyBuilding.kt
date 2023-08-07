package pg.lv3

class NotDestroyBuilding {

    /**
     * 코드의 주요 로직은 다음과 같이 동작합니다:
     *
     * diff 배열 초기화: 입력으로 주어진 board의 크기와 동일한 크기의 diff 배열을 생성합니다. 이 배열은 각 칸에 대해 파괴와 회복에 따라 변경된 내구도의 차이를 저장하는 배열입니다.
     *
     * 스킬 적용: 주어진 skill 배열을 순회하면서 스킬을 적용합니다. 스킬 타입에 따라 내구도를 낮추거나 높이는 작업을 합니다. 이때 직사각형 범위 내의 칸들에 대한 내구도 차이를 diff 배열에 누적하여 저장합니다.
     *
     * 누적된 차이를 적용: diff 배열에 저장된 누적 차이를 이용해 board 배열의 내구도를 수정합니다. 이때 각 칸에 대해 누적된 차이를 더해줍니다.
     *
     * 파괴되지 않은 건물 수 계산: 수정된 board 배열을 순회하면서 내구도가 1 이상인 칸들을 카운트합니다. 이 값이 파괴되지 않은 건물의 수입니다.
     *
     * 위의 로직을 따라가면서 solution 함수는 주어진 board와 skill에 대해 파괴되지 않은 건물의 수를 계산하고 반환합니다. main 함수에서는 예시 입력을 사용하여 이 함수를 호출하고 그 결과를 출력합니다.
     */
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        val n = board.size
        val m = board[0].size

        val diff = Array(n) { IntArray(m) }

        for (s in skill) {
            val type = s[0]
            val r1 = s[1]
            val c1 = s[2]
            val r2 = s[3]
            val c2 = s[4]
            val degree = s[5]

            if (type == 1) {
                diff[r1][c1] -= degree
                if (r2 + 1 < n) diff[r2 + 1][c1] += degree
                if (c2 + 1 < m) diff[r1][c2 + 1] += degree
                if (r2 + 1 < n && c2 + 1 < m) diff[r2 + 1][c2 + 1] -= degree
            } else {
                diff[r1][c1] += degree
                if (r2 + 1 < n) diff[r2 + 1][c1] -= degree
                if (c2 + 1 < m) diff[r1][c2 + 1] -= degree
                if (r2 + 1 < n && c2 + 1 < m) diff[r2 + 1][c2 + 1] += degree
            }
        }

        var result = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (i > 0) diff[i][j] += diff[i - 1][j]
                if (j > 0) diff[i][j] += diff[i][j - 1]
                if (i > 0 && j > 0) diff[i][j] -= diff[i - 1][j - 1]
                board[i][j] += diff[i][j]
                if (board[i][j] > 0) result++
            }
        }

        return result
    }
}
