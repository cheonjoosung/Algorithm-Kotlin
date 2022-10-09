package pg.lv0

class PowNumber {

    fun solution(n: Int): Int {
        return if (n % Math.sqrt(n.toDouble()).toInt() == 0) 1 else 2
    }
}