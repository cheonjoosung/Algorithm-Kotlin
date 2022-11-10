package pg.lv1

import java.lang.StringBuilder

fun main() {
    NumberFriend().solution("100","2345")
    NumberFriend().solution("100","203045")
    NumberFriend().solution("100","123450")
    NumberFriend().solution("12321","42531")
    NumberFriend().solution("5525","1255")
//    "100"	"2345"	"-1"
//    "100"	"203045"	"0"
//    "100"	"123450"	"10"
//    "12321"	"42531"	"321"
//    "5525"	"1255"	"552"
}

class NumberFriend {

    fun solution(X: String, Y: String): String {

        var answer = ""

        val arrX = IntArray(10)
        val arrY = IntArray(10)

        toArr(X, arrX)
        toArr(Y, arrY)

        val sb = StringBuilder()

        for (i in arrX.indices.reversed()) {
            while (arrX[i] >= 1 && arrY[i] >= 1) {
                arrX[i]--
                arrY[i]--

                sb.append(i)
            }
        }

        answer = sb.toString()
        return when {
            answer == "" -> "-1"
            answer.startsWith("0") -> "0"
            else -> answer
        }
    }

    private fun toArr(str: String, arr: IntArray) {
        for (element in str) {
            val index = element - '0'
            arr[index]++
        }
    }
}