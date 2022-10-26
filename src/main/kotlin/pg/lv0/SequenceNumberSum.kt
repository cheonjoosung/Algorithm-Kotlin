package pg.lv0

class SequenceNumberSum {

    fun solution(num: Int, total: Int): IntArray {

        val sum = (num * (num-1)) / 2
        val n = (total - sum)/num
        /**
         * n 1 = n
         * n 2 = n + (n+1) = 2n + 1
         * n 3 = n + (n+1) + (n+2) = 3n + 3
         * n 4 = n + (n+1) + (n+2) + (n+3) = 4n + 6
         */

        return (n until n+num).map { it }.toIntArray()
    }
}