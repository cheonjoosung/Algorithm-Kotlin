package backjun.g3

import java.io.BufferedReader
import java.io.InputStreamReader

class Scale {

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        val token = br.readLine().split(" ")

        val arr: MutableList<Int> = mutableListOf()

        for (i in 0 until n) {
            arr.add(token[i].toInt())
        }

        arr.sort()

        /*
            다음 원소값이 누적합 + 1 보다 크면 만들지 못하는 무게
            1 1 2 3  6  7  30
            1 2 4 7 13 20  21...
            누적합은 추로 만들 수 있는 최소 무게 누적합이 4라면 1,2,3,4는 다 만들 수 있음 이보다 큰 숫자가 오면 못만듬듬
            1 1 2  6
            1 2 4  5 = (sum + 1) 5를 못만듬
        */
        var sum = 0
        for (i in 0 until n) {

            if (sum + 1 < arr[i]) {
                break
            }

            sum += arr[i]
        }

        println(sum + 1)
    }
}