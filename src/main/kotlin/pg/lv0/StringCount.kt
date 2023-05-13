package pg.lv0

fun main() {
    StringCount().solution("Programmers").forEach { print("$it ") }
}

class StringCount {

    fun solution(my_string: String): IntArray {
        val answer = IntArray(52) { 0 }

        my_string.forEach {
            val code = if (it.isUpperCase()) {
                it.code - 65
            } else {
                it.code - 65 - 6
            }

            answer[code]++
        }

        return answer
    }
}