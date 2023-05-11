package pg.lv0

fun main() {
    CovertSequenceCondition2().solution(intArrayOf(1, 2, 3, 100, 99, 98)).also { println(it) }
}

class CovertSequenceCondition2 {

    fun solution(arr: IntArray): Int {
        var answer: Int = 0

        var str = arr.joinToString(",")
        var result: IntArray = arr.copyOf()

        while (true) {
            answer++

            result = result.map {
                if (it >= 50 && it % 2 == 0) it / 2
                else if (it < 50 && it % 2 == 1) it * 2 + 1
                else it
            }.toIntArray()

            val temp = result.joinToString(",")
            if (str == temp) break
            else {
                str = temp
            }
        }

        return answer-1
    }
}