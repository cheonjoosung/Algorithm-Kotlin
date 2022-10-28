package pg.lv0

class TriangleCondition {

    fun solution(sides: IntArray): Int {
        var answer: Int = 0

        // a, b, num
        // a, num , b

        sides.sort()

        val min = sides[1] - sides[0]
        val max = sides[1] + sides[0]
        return (min+1 until max).count()
    }
}