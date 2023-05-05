package pg.lv0

fun main() {
    SimpleLogicCalculator().solution(x1 = false, x2 = true, x3 = true, x4 = true).also { println(it) }
    SimpleLogicCalculator().solution(x1 = true, x2 = false, x3 = false, x4 = false).also { println(it) }
}

class SimpleLogicCalculator {

    fun solution(x1: Boolean, x2: Boolean, x3: Boolean, x4: Boolean): Boolean {
        return ((x1 || x2) && (x3 || x4))
    }
}