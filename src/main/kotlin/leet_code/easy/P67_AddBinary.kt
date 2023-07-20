package leet_code.easy

import java.math.BigDecimal

class P67_AddBinary {
    fun addBinary(a: String, b: String): String {
        return (a.toBigInteger(2) + b.toBigInteger(2)).toString(2)
    }
}

fun main() {
    P67_AddBinary().addBinary("11","1").also { println(it) }
    P67_AddBinary().addBinary("1010","1011").also { println(it) }
}