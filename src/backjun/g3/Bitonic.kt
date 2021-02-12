package backjun.g3

import java.util.*

class Bitonic {
    fun solution() {
        val sc = Scanner(System.`in`)

        val n = sc.nextInt()
        var arr = mutableListOf<Int>()

        for (i in 0 until n)
            arr.add(sc.nextInt())

        /*
        1. 모든 부분수열을 만들어야겠네? - 2의 n제곱 - 1
        2. 맥스값의 인덱스 찾고 증가하다가 그 이후부터 감소하는지 확인하기
         */
        var answer = 1
        for (i in 1..n) {
            var isVisited = Array(n) { false }
            findSubArray(arr, mutableListOf(), isVisited, i, 0, 0)
        }


    }

    fun findSubArray(
        arr: MutableList<Int>, temp: MutableList<Int>,
        isVisited: Array<Boolean>, total: Int, cnt: Int, idx: Int
    ) {

        if (cnt == total) { // 바이토닉체크
            val max = temp.maxByOrNull { it }

            max?.let {
                val maxIdx = temp.indexOfFirst { it == max }

                println(temp)
                for (i in 0..maxIdx) {
                    print("${temp[i]} ")
                }

                print("// ")
                for (i in maxIdx downTo temp.size-1) {
                    print("${temp[i]}")
                }
                println()
            }
            /*
            1. 맥스인덱스 찾기
            2. 0 to 맥스인덱스 증가하는가?
            3. 맥스인덱스 to 마지막까지 감소하는가
             */
            return
        }
        for (i in idx until arr.size) {
            if (isVisited[i]) continue

            isVisited[i] = true
            temp.add(arr[i])
            findSubArray(arr, temp, isVisited, total, cnt + 1, i+1)

            isVisited[i] = false
            temp.remove(arr[i])
        }
    }
}