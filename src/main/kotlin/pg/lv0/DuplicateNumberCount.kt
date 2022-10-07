package pg.lv0

class DuplicateNumberCount {

    fun solution(array: IntArray, n: Int): Int {
        return array.filter { it == n }.count()
    }
}