package pg.lv0

class CountNumbering {

    fun solution(n: Int): Int {
        return (1..n).asSequence().filter { n % it == 0 }.count()
    }
}