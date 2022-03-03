package backjun.g3

import java.util.*
class TermProject {

    var answer = 0
    fun main() {
        val sc = Scanner(System.`in`)

        val tc = sc.nextInt()

        for (t in 1..tc)  {

            val n = sc.nextInt()
            val array = IntArray(n + 1) { 0 }
            val isVisited = BooleanArray(n + 1) { false }
            val isSearchEnd = BooleanArray(n + 1) { false }

            for (i in 1..n)
                array[i] = sc.nextInt()

            answer = 0
            for (i in 1..n) {
                check(i, array, isVisited, isSearchEnd)
            }
            println(n - answer)
        }

        sc.close()
    }

    private fun check(idx: Int, array: IntArray, isVisited: BooleanArray, isSearchEnd: BooleanArray) {

        isVisited[idx] = true

        var next = array[idx]

        if (!isVisited[next]) {
            check(next, array, isVisited, isSearchEnd)
        } else {
            if (!isSearchEnd[next]) {
                answer++

                while(next != idx) {
                    answer++
                    next = array[next]
                }
            }
        }

        isSearchEnd[idx] = true
    }
}