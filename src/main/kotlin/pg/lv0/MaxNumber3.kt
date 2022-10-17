package pg.lv0

class MaxNumber3 {

    fun solution(numbers: IntArray): Int {
        numbers.sort()

        return Math.max(numbers[0] * numbers[1], numbers[numbers.size-1] * numbers[numbers.size-2])
    }
}