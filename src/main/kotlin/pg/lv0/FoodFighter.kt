package pg.lv0

fun main() {
    FoodFighter().solution(intArrayOf(1, 3, 4, 6)).run { println(this) }
    FoodFighter().solution(intArrayOf(1, 7, 1, 2)).run { println(this) }
}

class FoodFighter {

    fun solution(food: IntArray): String {
        val answer = StringBuilder()

        val sb = StringBuilder()

        for (i in 1 until food.size) {
            if (food[i] == 1) continue
            else {
               repeat(food[i] / 2) {
                   sb.append(i)
               }
            }
        }

        answer.append(sb.toString()).append("0").append(sb.toString().reversed())
        return answer.toString()
    }
}