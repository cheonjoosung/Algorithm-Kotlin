package pg.lv0

fun main() {
    SumOfTwoNumber().solution("582", "734").also { println(it) }
    SumOfTwoNumber().solution("18446744073709551615", "287346502836570928366").also { println(it) }
    SumOfTwoNumber().solution("0", "0").also { println(it) }
}

class SumOfTwoNumber {

    fun solution(a: String, b: String): String {
        return (a.toBigDecimal() + b.toBigDecimal()).toString()
    }
}