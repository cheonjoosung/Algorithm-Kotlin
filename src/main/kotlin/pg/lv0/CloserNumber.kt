package pg.lv0

class CloserNumber {

    fun solution(array: IntArray, n: Int): Int {
        var min: Int = Int.MAX_VALUE
        var findNumber = 0

        array.sorted().forEachIndexed { index, it ->
            if (Math.abs(it - n) < min) {
                min = Math.abs(it - n)
                findNumber = it
            }
        }
        return findNumber
    }
}