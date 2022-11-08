package pg.lv1

fun main() {
    CokeProblem().solution(2, 1, 20).run { println(this) }
    CokeProblem().solution(3, 1, 20).run { println(this) }
}

class CokeProblem {

    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0

        var remain = n

        while (remain / a != 0) {
            val newCoke = (remain / a) * b
            answer += newCoke
            remain = newCoke + (remain % a)
        }

        return answer
    }
}