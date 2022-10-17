package pg.lv0

fun main() {
    Factorial().solution(7)
}

class Factorial {

    fun solution(n: Int): Int {
        val fact = IntArray(10 + 1) { 0 }
        fact[0] = 1
        fact[1] = 1
        fact[2] = 2

        for (i in 2..10) {
            fact[i] = i * fact[i-1]

            if (fact[i] > n) {
                break
            }
        }

        var findNumber = 10
        for (i in fact.indices) {
            if (fact[i] > n) {
                findNumber = i - 1
                break
            }
        }

        return findNumber

    }
}