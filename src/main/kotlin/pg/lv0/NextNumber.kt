package pg.lv0

class NextNumber {

    fun solution(common: IntArray): Int {

        return if ((common[2] - common[1]) == (common[1] - common[0])) {
            common[common.size-1] + (common[common.size-1] - common[common.size-2])
        } else {
            common[common.size-1] * (common[common.size-1]/common[common.size-2])
        }
    }
}