package pg.lv0

class ArrayRotation {

    fun solution(numbers: IntArray, direction: String): IntArray {
        val answer = IntArray(numbers.size) { 0 }


        for (i in numbers.indices) {
            if (direction == "left")
                answer[i] = numbers[(i + 1) % numbers.size]
            else
                answer[i] = numbers[(i - 1 + numbers.size) % numbers.size]
        }

        return answer
    }
}