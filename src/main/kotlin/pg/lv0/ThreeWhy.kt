package pg.lv0

fun main() {
    ThreeWhy().solution(15)
}

class ThreeWhy {

    fun solution(n: Int): Int {
        var answer: Int = 0

        var j = 1
        val array = IntArray(n + 1) { 0 }
        for (i in 1..n) {

            while ((j % 3 == 0) || (j.toString().contains("3"))) {
                j++
            }

            array[i] = j++
        }

        return array[n]
    }
}