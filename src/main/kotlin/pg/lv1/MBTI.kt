package pg.lv1

import java.lang.StringBuilder

fun main() {

    val s1 = arrayOf("AN", "CF", "MJ", "RT", "NA")
    val c1 = intArrayOf(5, 3, 2, 7, 5)
    val s2 = arrayOf("TR", "RT", "TR")
    val c2 = intArrayOf(7, 1, 3)

    println(solution(s1, c1)) //TCMA
    println(solution(s2, c2))  //RCJA
}

fun solution(survey: Array<String>, choices: IntArray): String {
    val answer = StringBuilder()

    val size = survey.size
    val arr = IntArray(8) { 0 }

    /**
     * RT, CF, JM, AN
     */
    for (i in 0 until size) {
        check(choices[i] - 4, survey[i], arr)
    }

    for (i in 0..3) {

        val res = if (arr[i*2] >= arr[i*2 + 1]) {
            when (i) {
                0 -> "R"
                1 -> "C"
                2 -> "J"
                else -> "A"
            }
        } else {
            when (i) {
                0 -> "T"
                1 -> "F"
                2 -> "M"
                else -> "N"
            }
        }

        answer.append(res)
    }

    return answer.toString()
}

private fun check(point: Int, choice: String, arr: IntArray) {

    when {
        point == 0 -> {}
        point < 0 -> point(choice[0], arr, Math.abs(point))
        point > 0 -> point(choice[1], arr, point)
    }

}

private fun point(ch: Char, arr: IntArray, point: Int) {
    when (ch) {
        'R' -> arr[0] += point
        'T' -> arr[1] += point
        'C' -> arr[2] += point
        'F' -> arr[3] += point
        'J' -> arr[4] += point
        'M' -> arr[5] += point
        'A' -> arr[6] += point
        'N' -> arr[7] += point
    }
}