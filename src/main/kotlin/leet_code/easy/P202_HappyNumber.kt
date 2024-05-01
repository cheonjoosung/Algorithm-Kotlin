package leet_code.easy

import kotlin.math.pow

class P202_HappyNumber {
    fun isHappy(n: Int): Boolean {
        var num = n
        val visit = BooleanArray(1000) { false }

        while (num != 1) {
            num = calculator(num)
            println(num)
            if (visit[num]) break
            visit[num] = true
        }

        return (num == 1)
    }

    private fun calculator(num: Int): Int {
        val str = num.toString()
        var sum = 0
        for (i in str.indices) {
            val digit = str[i].toString().toInt()
            sum += digit.toDouble().pow(2.0).toInt()
        }

        return sum
    }
}

fun main() {
    P202_HappyNumber().isHappy(19).also { println(it) } // t
    P202_HappyNumber().isHappy(2).also { println(it) } // f
}