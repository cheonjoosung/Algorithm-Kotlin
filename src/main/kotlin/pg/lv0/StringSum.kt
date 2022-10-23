package pg.lv0

fun main() {
    StringSum().solution("3 + 4 + 13 - 99").also { println(it) }
}

class StringSum {

    fun solution(my_string: String): Int {

        val token = my_string.split(" ")
        var answer: Int = token[0].toInt()

        // 3 + 4 + 7
        for (i in 1 until token.size) {
            if (i % 2 == 1) {
                if (token[i] == "+") answer += token[i + 1].toInt()
                else answer -= token[i + 1].toInt()
            }
        }

        return answer
    }
}