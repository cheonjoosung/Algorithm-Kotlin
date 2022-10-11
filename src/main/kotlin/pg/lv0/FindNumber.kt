package pg.lv0

fun main() {
    println(FindNumber().solution(232443, 4))
}

class FindNumber {

    fun solution(num: Int, k: Int): Int {
        return num.toString().indexOfFirst { it == k.digitToChar() } + 1
    }
}