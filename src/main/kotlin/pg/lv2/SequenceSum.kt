package pg.lv2

fun main() {
    SequenceSum().solution(intArrayOf(1, 2, 3, 4, 5), 7).forEach { println(it) } //2,3
    SequenceSum().solution(intArrayOf(1, 1, 1, 2, 3, 4, 5), 5).forEach { println(it) } // 6,6
    SequenceSum().solution(intArrayOf(2, 2, 2, 2, 2), 6).forEach { println(it) } //0,2
}

class SequenceSum {
    fun solution(sequence: IntArray, k: Int): IntArray {

        var left = 0
        var right = 0

        var sum = sequence[right]
        val answer = intArrayOf(0, Int.MAX_VALUE)

        while (left < sequence.size) {
            if (sum < k) {
                if (right == sequence.size - 1) break
                sum += sequence[++right]
            } else {
                if (sum == k) {
                    if (answer[1] - answer[0] > right - left) {
                        answer[0] = left
                        answer[1] = right
                    }
                }
                sum -= sequence[left++]
            }
        }

        return answer
    }
}