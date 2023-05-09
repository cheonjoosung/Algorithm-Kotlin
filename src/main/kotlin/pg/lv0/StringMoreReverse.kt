package pg.lv0

fun main() {
    StringMoreReverse().solution("rermgorpsam",
        arrayOf(intArrayOf(2, 3), intArrayOf(0, 7), intArrayOf(5, 9), intArrayOf(6, 10))
    ).also { println(it) }
}

class StringMoreReverse {

    fun solution(my_string: String, queries: Array<IntArray>): String {
        var answer: String = my_string

        for (query in queries) {
            val s = query[0]
            val e = query[1]

            val subStringReverse = answer.substring(s, e+1).reversed()
            answer = answer.replaceRange(s, e+1, subStringReverse)
            //println("$s $e $subStringReverse $answer")
        }

        return answer
    }
}