package pg.lv0

fun main() {
    CountString().solution("banana" , "ana").also { println(it) }
    CountString().solution("aaaa" , "aa").also { println(it) }
}

class CountString {

    fun solution(myString: String, pat: String): Int {
        var answer: Int = 0

        for (i in myString.indices) {
            answer += if (myString.regionMatches(i, pat, 0, pat.length)) {
                1
            } else {
                0
            }
        }

        return answer
    }
}