package leet_code.easy

class P13_RomanToInteger {
    fun romanToInt(s: String): Int {

        val map = hashMapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)
        var result = 0
        var i = 0

        while (i < s.length) {
            val current = map[s[i]] ?: 0

            if (i < s.length -1) {
                val next = map[s[i+1]] ?: 0

                if (current < next) {
                    result += next - current
                    i += 2
                    continue
                }
            }

            result += current
            i++
        }

        return result
    }
}

fun main() {
    //P13_RomanToInteger().romanToInt("III").also { println(it) }
    //P13_RomanToInteger().romanToInt("LVIII").also { println(it) }
    P13_RomanToInteger().romanToInt("MCMXCIV").also { println(it) }
}