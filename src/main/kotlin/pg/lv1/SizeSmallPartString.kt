package pg.lv1

fun main() {
    SizeSmallPartString().solution("3141592", "271").also { println(it) } //2
    println()
    SizeSmallPartString().solution("500220839878", "7").also { println(it) } //8
    println()
    SizeSmallPartString().solution("10203", "15").also { println(it) } //3
}

class SizeSmallPartString {

    fun solution(t: String, p: String): Int {
        var answer: Int = 0

        for (i in 0 until t.length - p.length + 1) {
            val sub = t.substring(i, i + p.length)

            if (sub.toLong() <= p.toLong()) {
                answer++
            }
        }
        return answer
    }
}