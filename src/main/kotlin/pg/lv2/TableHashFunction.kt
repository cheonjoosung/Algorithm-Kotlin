package pg.lv2

class TableHashFunction {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        val sortedData = data.sortedWith(compareBy({ it[col - 1] }, { -it[0] }))
        var hashValue = 0

        for (i in row_begin - 1 until row_end) {
            val tuple = sortedData[i]
            var sum = 0

            for (j in tuple.indices) {
                sum += tuple[j] % (i + 1)
            }

            hashValue = hashValue xor sum
        }

        return hashValue
    }
}