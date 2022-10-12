package pg.lv0

class SevenCount {

    fun solution(array: IntArray): Int {
        return array.joinToString("").count { it == '7' }
    }
}