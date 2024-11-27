package pg.lv3

class PurseSequence {
    fun solution(sequence: IntArray): Long {
        // 펄스 수열 패턴 1: [1, -1, 1, -1, ...]
        val pulse1 = sequence.mapIndexed { index, value -> if (index % 2 == 0) value else -value }.toIntArray()
        // 펄스 수열 패턴 2: [-1, 1, -1, 1, ...]
        val pulse2 = sequence.mapIndexed { index, value -> if (index % 2 == 0) -value else value }.toIntArray()

        // 두 변형에서 각각 최대 부분합 계산
        val maxPulse1 = maxSubarraySum(pulse1)
        val maxPulse2 = maxSubarraySum(pulse2)

        // 두 값 중 최대값 반환
        return maxOf(maxPulse1, maxPulse2)
    }

    // 최대 부분합 계산 (Kadane's Algorithm)
    private fun maxSubarraySum(arr: IntArray): Long {
        var maxSum = Long.MIN_VALUE
        var currentSum = 0L

        for (value in arr) {
            currentSum = maxOf(value.toLong(), currentSum + value.toLong())
            maxSum = maxOf(maxSum, currentSum)
        }

        return maxSum
    }
}

fun main() {
    PurseSequence().solution(intArrayOf(2, 3, -6, 1, 3, -1, 2, 4)).also { println(it) }
}