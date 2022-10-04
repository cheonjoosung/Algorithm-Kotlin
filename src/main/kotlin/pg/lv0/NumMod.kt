package pg.lv0

class NumMod {

    fun solution(num1: Int, num2: Int): Int {
        return mod(num1, num2)
    }

    private fun mod(a: Int, b: Int) = a % b
}