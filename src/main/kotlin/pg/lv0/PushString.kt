package pg.lv0

import java.lang.StringBuilder

fun main() {
    PushString().solution("hello", "ohell")
}

class PushString {

    fun solution(A: String, B: String): Int {
        var answer: Int = -1

        for (i in A.indices) {
            val sb = StringBuilder()
            for (j in A.indices) {
                // 0 -> 1, 1 -> 2, 2->3
                sb.append(A[(j - i + A.length) % A.length])
            }

            println(sb.toString())
            if (sb.toString() == B) {
                return i
            }
        }

        return answer
    }
}