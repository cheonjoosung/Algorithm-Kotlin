package pg.lv3

class NotDestroyBuilding {

    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        var answer = 0

        /**
         * 0 <= r <= 100, 0 <= c <= 100, 0 <= s <= 250000
         * skill(type, r1, c1, r2, c2, damage) type 1 공격, 2 수비, (r1,c1) to (r2,c2)
         * O(100 * 100 * 250000) = 25억이므로 약 25초 예상
         */

        for (s in skill) {
            val type = s[0]
            val damage = s[5]

            for (i in s[1]..s[3]) {
                for (j in s[2]..s[4]) {
                    if (type == 1) {
                        board[i][j] -= damage
                    } else {
                        board[i][j] += damage
                    }
                }
            }
        }

        for (arr in board) {
            answer += arr.count { it >= 1 }
        }

        return answer
    }
}