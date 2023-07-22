package leet_code.easy

import kotlin.math.sqrt

class P69_Sqrt {
    fun mySqrt(x: Int): Int {
        return sqrt(x.toDouble()).toInt()
    }
}

fun main() {
    P69_Sqrt().mySqrt(4).also { println(it) } // 2
    P69_Sqrt().mySqrt(8).also { println(it) } // 2
}