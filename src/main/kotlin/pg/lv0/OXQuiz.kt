package pg.lv0

fun main() {
    OXQuiz().solution(arrayOf("3 - 4 = -3", "5 + 6 = 11")).forEach { println(it) }
    println()
    OXQuiz().solution(arrayOf("19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2")).forEach { println(it) }
}

class OXQuiz {

    fun solution(quiz: Array<String>): Array<String> {
        val answer: Array<String> = Array(quiz.size) { "X" }

        for (i in quiz.indices) {
            val token = quiz[i].split(" ")

            var cur = token[0].toInt()

            for (j in 2 until token.size step 2) {
                val num = token[j].toInt()

                when (token[j-1]) {
                    "-" -> cur -= num
                    "+" -> cur += num
                    "=" -> if (cur == num) answer[i] = "O" else answer[i] = "X"
                }
            }
        }

        return answer
    }
}