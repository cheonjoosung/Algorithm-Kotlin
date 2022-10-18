package pg.lv0

import pg.lv2.solution

fun main() {
    BinaryAdd().solution("10", "111")
}
class BinaryAdd {

    fun solution(bin1: String, bin2: String): String {
        return (bin1.toInt(2) + bin2.toInt(2)).toString(2)
    }
}