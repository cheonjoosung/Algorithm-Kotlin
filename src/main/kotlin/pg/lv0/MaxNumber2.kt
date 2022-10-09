package pg.lv0

class MaxNumber2 {

    fun solution(numbers: IntArray): Int {
        numbers.sort()
        return numbers[numbers.size-1] * numbers[numbers.size-2]
    }
}