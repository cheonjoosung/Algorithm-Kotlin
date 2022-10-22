package pg.lv0

fun main() {
    HiddenNumberSum().solution("aAb1B2cC34oOp").also { println(it) }
    HiddenNumberSum().solution("1a2b3c4d123Z").also { println(it) }
}

class HiddenNumberSum {

    fun solution(my_string: String): Int {
        val token = my_string.lowercase().split(Regex("[a-z]"))
        var ans = 0
        token.forEach {
            try {
                ans += it.toInt()
            } catch (e: Exception) {

            }
        }

        return ans
    }
}