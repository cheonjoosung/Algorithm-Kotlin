package pg.lv2

import java.util.Stack


fun main() {
    BackBigNumberFind().solution(intArrayOf(2, 3, 3, 5)).forEach { print("$it ") } //3, 5, 5, -1
    println()
    BackBigNumberFind().solution(intArrayOf(9, 1, 5, 3, 6, 2)).forEach { print("$it ") } //-1, 5, 6, 6, -1, -1
}

class BackBigNumberFind {

    fun solution(numbers: IntArray): IntArray {
        val answer: IntArray = IntArray(numbers.size) { -1 }

        val stack = Stack<Int>()

        for (i in numbers.indices) {
            // 전값보다 큰경우
            if (stack.isEmpty() || numbers[i] < numbers[i - 1]) stack.push(i)
            else {
                // 현재값보다 작은 인덱스는 팝
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    answer[stack.pop()] = numbers[i]
                }
                stack.push(i)
            }
        }

        return answer
    }

    /**
     * 시간초과
     */
    fun solution2(numbers: IntArray): IntArray {
        val answer: IntArray = IntArray(numbers.size) { -1 }

        for (i in numbers.indices) {
            val findNum = numbers.sliceArray(i + 1 until numbers.size).find { it > numbers[i] } ?: -1
            answer[i] = findNum
        }

        return answer
    }
}