package pg.lv0

fun main() {
    ComposeNumberFind().solution(10)
}

class ComposeNumberFind {

    fun solution(n: Int): Int {
        var answer: Int = 0
        for (i in 1..n) {
            var cnt = 0

            for (j in 1..i) {
                if (i % j == 0) cnt++
            }

            if (cnt >= 3) answer++
        }
        return answer
    }
}