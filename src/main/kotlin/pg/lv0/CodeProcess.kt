package pg.lv0

fun main() {
    CodeCut().solution("abc1abc1abc").also { println(it) } //acbac
}

class CodeCut {

    fun solution(code: String): String {
        val sb = StringBuilder()
        var mode = 0

        code.forEachIndexed { index, c ->
            when (c) {
                '0' -> mode = if (mode == 0) 1 else 0
                '1' -> mode = if (mode == 1) 0 else 1
                else -> {
                    if (index % 2 == 0) {
                        if (mode == 0) sb.append(c)
                    } else {
                        if (mode == 1) sb.append(c)
                    }
                }
            }
        }

        return if (sb.toString().isEmpty()) "EMPTY" else sb.toString()
    }
}