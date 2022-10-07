package pg.lv0

class TowNumDivide {

    fun solution(num1: Int, num2: Int): Int {
        return ((num1.toDouble() / num2.toDouble()) * 1000).toInt()
    }
}