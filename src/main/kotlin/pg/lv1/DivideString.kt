package pg.lv1

fun main() {
    DivideString().solution("banana").also { println(it) } //3
    DivideString().solution("abracadabra").also { println(it) } //6
    DivideString().solution("aaabbaccccabba").also { println(it) } //3

}

class DivideString {

    fun solution(s: String): Int {

        var ch = s[0]

        var answer: Int = 0
        var count = 0
        var diff = 0

        for (i in s.indices) {
            if (count == diff) {
                answer++
                ch = s[i]
            }

            if (ch == s[i]) {
                count++
            } else {
                diff++
            }
        }

        return answer
    }
}