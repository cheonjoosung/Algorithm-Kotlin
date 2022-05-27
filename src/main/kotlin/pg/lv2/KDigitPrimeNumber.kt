package pg.lv2

class KDigitPrimeNumber {

    fun main() {

        println(solution(437674, 3)) // 3
        println(solution(110011, 10)) // 3
    }

    fun solution(n: Int, k: Int): Int {
        var answer = 0

        n.toString(k)
            .split("0")
            .filter { it.isNotEmpty() }
            .map { it.toLong() }
            .forEach {
                if (it == 2L) answer++
                else if (it > 2L) {
                    var isPossible = true
                    for (i in 2..Math.sqrt(it.toDouble()).toInt()) {
                        if (it % i == 0L) {
                            isPossible = false
                            break
                        }
                    }
                    if (isPossible) answer++
                }
            }

        return answer
    }
}