package pg.lv0

import pg.lv2.solution

fun main() {
    WantedString().solution("AbCdEfG", "aBc").also { println(it) }
    WantedString().solution("aaAA", "aaaaa").also { println(it) }
}

class WantedString {

    fun solution(myString: String, pat: String): Int {
        return if (myString.contains(pat, true)) 1 else 0
    }
}