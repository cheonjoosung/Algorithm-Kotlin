package pg.lv0

class CharacterPosition {

    fun solution(keyinput: Array<String>, board: IntArray): IntArray {
        val answer: IntArray = intArrayOf(0, 0)

        for (input in keyinput) {
            when (input) {
                "up" -> if (!isOverBoard(answer[1] + 1, board[1])) answer[1] = answer[1] + 1
                "down" -> if (!isOverBoard(answer[1] - 1, board[1])) answer[1] = answer[1] - 1
                "left" -> if (!isOverBoard(answer[0] - 1, board[0])) answer[0] = answer[0] - 1
                "right" -> if (!isOverBoard(answer[0] + 1, board[0])) answer[0] = answer[0] + 1
            }
        }

        return answer
    }

    private fun isOverBoard(position: Int, size: Int): Boolean {
        return Math.abs(position) > (size - 1) / 2
    }
}