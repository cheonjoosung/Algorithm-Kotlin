package pg.lv0

fun main(args: Array<String>) {
    val (n) = readLine()!!.split(' ').map(String::toInt)

    (1..n).forEach {
        repeat(it) {
            print("*")
        }
        println()
    }
}