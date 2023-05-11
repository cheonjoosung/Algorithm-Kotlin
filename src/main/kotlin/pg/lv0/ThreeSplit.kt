package pg.lv0

fun main() {
    ThreeSplit().solution("baconlettucetomato").forEach { println(it) }
    ThreeSplit().solution("abcd").forEach { println(it) }
    ThreeSplit().solution("cabab").forEach { println(it) }
}

class ThreeSplit {

    fun solution(myStr: String): Array<String> {
        val result = myStr.split(Regex("[a|b|c]")).filter { it.isNotEmpty() }
        return if (result.isEmpty()) arrayOf("EMPTY") else result.toTypedArray()
    }
}