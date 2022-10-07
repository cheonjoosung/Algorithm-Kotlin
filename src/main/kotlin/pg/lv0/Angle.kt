package pg.lv0

class Angle {

    fun solution(angle: Int): Int {
        return when (angle) {
            in 1..89 -> 1
            90 -> 2
            in 91..179 -> 3
            else -> 4
        }
    }
}