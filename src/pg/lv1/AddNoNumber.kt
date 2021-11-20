package pg.lv1

class AddNoNumber {

    fun solution(numbers: IntArray): Int {
        return (0..9).sum() - numbers.sum()
    }
}