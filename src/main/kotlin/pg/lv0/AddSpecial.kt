package pg.lv0

fun main() {
    AddSpecial().solution(3, 4, booleanArrayOf(true, false, false, true, true)).also { println(it) }
    AddSpecial().solution(7, 1, booleanArrayOf(false, false, false, true, false, false, false)).also { println(it) }
}

class AddSpecial {

    fun solution(a: Int, d: Int, included: BooleanArray): Int {
        var answer: Int = 0

        included.forEachIndexed { index, b ->
            if (b) {
                answer += a + (d*index)
            }
        }
        return answer
    }
}