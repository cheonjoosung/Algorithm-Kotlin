package pg.lv1

fun main() {
    ClosestSameWord().solution("banana").forEach { print("$it ") } //[-1, -1, -1, 2, 2, 2]
    println()
    ClosestSameWord().solution("foobar").forEach { print("$it ") } //[-1, -1, 1, -1, -1, -1]
}

class ClosestSameWord {

    fun solution(s: String): IntArray {
        val answer: IntArray = IntArray(s.length) { -1 }

        for (i in s.indices) {
            val sub = s.substring(0 until i)

            val findLastIndex = sub.indexOfLast { it == s[i] }
            if (findLastIndex != -1) answer[i] = (i-findLastIndex)
            //println("$sub $i $findLastIndex")
        }

        return answer
    }
}