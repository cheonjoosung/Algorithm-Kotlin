package pg.lv0

fun main() {
    println(KCount().solution(1, 13, 1))
}

class KCount {

    fun solution(i: Int, j: Int, k: Int): Int {

        with(StringBuilder()) {
            (i..j).forEach { append(it) }
            println(this)
            return this.count { it == k.digitToChar() }
        }
    }
}