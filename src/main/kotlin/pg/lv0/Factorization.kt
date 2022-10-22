package pg.lv0

fun main() {
    Factorization().solution(4)
}

class Factorization {

    fun solution(n: Int): IntArray {
        val list = mutableListOf<Int>()

        var num = n
        var i = 2

        while (i <= num) {
            if (num % i == 0) {
                if (!list.contains(i)) list.add(i)
                num /= i
            } else {
                i++
            }
        }

        return list.toIntArray()
    }
}