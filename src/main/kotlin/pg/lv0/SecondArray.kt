package pg.lv0

class SecondArray {

    fun solution(num_list: IntArray, n: Int): Array<IntArray> {
        val size = num_list.size
        val answer = Array(size / n) { IntArray(n) { 0 } }

        for (i in answer.indices) {
            for (j in answer[i].indices) {
                answer[i][j] = num_list[i * n + j]
            }
        }

        return answer
    }
}