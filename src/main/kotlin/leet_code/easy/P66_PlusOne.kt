package leet_code.easy

import java.math.BigDecimal

class P66_PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        val str = digits.joinToString("").toBigDecimal()
        return (str.plus(BigDecimal.ONE)).toString().map { it.toString().toInt() }.toIntArray()
    }
}

fun main() {
    P66_PlusOne().plusOne(intArrayOf(1,2,3)).forEach { println(it) }
}