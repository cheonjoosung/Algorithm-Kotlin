package pg.lv0

import java.lang.StringBuilder


fun main() {
    OnlyOneString().solution("abcabcadc")
    OnlyOneString().solution("abdc")
    OnlyOneString().solution("hello")
}

class OnlyOneString {

    fun solution(s: String): String {
        val sb = StringBuilder()

        s.forEach { ch ->
            if (s.count { it == ch } == 1) {
                sb.append(ch)
            }
        }

        return sb.toString().toList().sorted().joinToString("")
    }
}