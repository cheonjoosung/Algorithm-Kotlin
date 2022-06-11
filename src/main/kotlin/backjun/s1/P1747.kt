import java.util.*
import kotlin.math.sqrt

fun main() {

    val sc = Scanner(System.`in`)
    val n = sc.nextInt()


    if (n == 1) {
        println(2)
    } else {
        val size = 1_003_001 + 1

        for (i in n until size) {
            if (isPrime(i) && reverseCheck(i)) {
                println(i)
                break
            }

        }
    }
}

fun isPrime(x: Int): Boolean {
    var i = 2

    while (i <= sqrt(x.toDouble())) {
        if (x % i == 0) {
            return false
        }

        i++
    }

    return true
}

fun reverseCheck(i: Int): Boolean {

    val strInt = i.toString()
    val size = strInt.length

    for (j in 0 until size / 2) {
        if (strInt[j] != strInt[size - j - 1]) {
            return false
        }
    }

    return true
}