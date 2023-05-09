package pg.lv0

fun main() {
    FindStringVeryLong().solution("AbCdEFG", "dE").also { println(it) }//	"AbCdE"
    FindStringVeryLong().solution("AAAAaaaa", "a").also { println(it) }//	"AAAAaaaa"
}

class FindStringVeryLong {

    /**
     * myString.substring(0, myString.lastIndexOf(pat) + pat.length)
     * Regex("[a-zA-Z]*$pat").find(myString)?.value ?: ""
     */
    fun solution(myString: String, pat: String): String {
        var answer: String = ""

        for (i in myString.indices) {
            val subString = myString.substring(i, Math.min(i + pat.length, myString.length))

            if (check(subString, pat)) {
                answer = myString.substring(0, i) + pat
                //println("일치")
            } else {
                //println("안 일치")
            }
        }
        return answer
    }

    private fun check(myString: String, pat: String): Boolean {
        //println("$myString $pat")
        for (i in pat.indices) {
            if (myString[i] != pat[i]) return false
        }

        return true
    }
}