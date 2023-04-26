package pg.lv0

import java.math.BigInteger

fun main() {
    solution("He11oWor1d"	,"lloWorl",	2).forEach { print(it) }
    println()
    solution("Program29b8UYP",	"merS123",	7).forEach { print(it) }
}

fun solution(my_string: String, overwrite_string: String, s: Int): String {
    val startIndex = s
    val endIndex = s + overwrite_string.length

    return my_string.replaceRange(startIndex, endIndex, overwrite_string)
}
