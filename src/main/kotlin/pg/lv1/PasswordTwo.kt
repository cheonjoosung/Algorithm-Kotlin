package pg.lv1

fun main() {
    PasswordTwo().solution("aukks", "wbqd", 5).also { println(it) } //happy
}

class PasswordTwo {

    fun solution(s: String, skip: String, index: Int): String {
        val answer = StringBuilder()

        for (i in s.indices) {
            var code = s[i].code

            for (j in 0 until index) {
                do {
                    code++
                    if (code >= 123) code -= 26

                } while (skip.contains(code.toChar()))
            }

            answer.append(code.toChar())
        }

        return answer.toString()
    }
}