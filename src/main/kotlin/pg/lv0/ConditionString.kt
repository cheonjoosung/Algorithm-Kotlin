package pg.lv0

fun main() {
    solution999(">", "=", 20, 50).also { println(it) }
    solution999(">", "!", 41, 78).also { println(it) }
}

fun solution999(ineq: String, eq: String, n: Int, m: Int): Int {

    return if (ineq == ">") {
        if (eq == "=") {
            if (n >= m) 1 else 0
        } else {
            if (n > m) 1 else 0
        }
    } else {
        if (eq == "=") {
            if (n <= m) 1 else 0
        } else {
            if (n < m) 1 else 0
        }
    }
}