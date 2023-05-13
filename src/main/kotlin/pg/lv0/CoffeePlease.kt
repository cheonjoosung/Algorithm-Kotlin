package pg.lv0

fun main() {
    CoffeePlease().solution(arrayOf("iceamericano", "americanoice")).also { println(it) }
}

class CoffeePlease {

    fun solution(order: Array<String>): Int {
        var answer: Int = 0

        order.forEach {
            answer += if (it.contains("anything")) 4500
            else {
                if (it.contains("americano")) 4500
                else 5000
            }
        }

        return answer
    }
}