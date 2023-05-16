package pg.lv0


import kotlin.math.pow
fun main() {
    ArrayLengthTwoDoubleMake().solution(intArrayOf(1,2,3,4,5,6)).forEach { println(it) }
}

class ArrayLengthTwoDoubleMake {

    fun solution(arr: IntArray): IntArray {

        val size = arr.size
        var maxSize = 1

        for (i in 0..10) {
            maxSize = 2.0.pow(i.toDouble()).toInt()

            if (size <= maxSize) break
        }

        val answer = IntArray(maxSize) { 0 }
        arr.forEachIndexed { index, i -> answer[index] = i }

        return answer
    }
}