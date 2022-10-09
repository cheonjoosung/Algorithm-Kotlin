package pg.lv0

class ArrayTwoMultiply {

    fun solution(numbers: IntArray): IntArray {
        return numbers.map { it*2 }.toIntArray()
    }
}