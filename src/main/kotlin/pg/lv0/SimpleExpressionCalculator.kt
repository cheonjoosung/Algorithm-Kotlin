package pg.lv0

fun main() {
    SimpleExpressionCalculator().solution("43 + 12").also { println(it) }
    SimpleExpressionCalculator().solution("0 - 7777").also { println(it) }
}

class SimpleExpressionCalculator {

    fun solution(binomial: String): Int {

        val exp = binomial.split(" ")

        return when (exp[1]) {
            "+" -> exp[0].toInt() + exp[2].toInt()
            "-" -> exp[0].toInt() - exp[2].toInt()
            else -> exp[0].toInt() * exp[2].toInt()
        }
    }
}