import java.util.*

fun main() {

    val sc = Scanner(System.`in`)

    val sb = StringBuilder()

    val a = sc.nextLong()
    val b = sc.nextLong()

    val gcd = getGCD(a.coerceAtLeast(b), a.coerceAtMost(b))
    for (i in 1..gcd) sb.append("1")

    println(sb.toString())
}

fun getGCD(_a: Long, _b: Long): Long {
    var a = _a
    var b = _b

    while (b > 0) {
        val tmp = a
        a = b
        b = tmp % b
    }

    return a
}
