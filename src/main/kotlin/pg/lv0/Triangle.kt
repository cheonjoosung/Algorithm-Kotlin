package pg.lv0

class Triangle {

    fun solution(sides: IntArray): Int {
        return if (sides.sum() > 2*sides.maxOrNull()!!) 1 else 2
    }
}