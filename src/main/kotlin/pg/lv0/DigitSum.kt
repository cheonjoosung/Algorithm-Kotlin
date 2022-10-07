package pg.lv0

class DigitSum {

    fun solution(n: Int): Int {
        return n.toString().toList().sumOf { it.digitToInt() }
    }
}