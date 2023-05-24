package pg.lv1

fun main() {
    CardDeck().solution(
        arrayOf("i", "drink", "water"),
        arrayOf("want", "to"),
        arrayOf("i", "want", "to", "drink", "water")
    ).also { println(it) }    //"Yes"
    CardDeck().solution(
        arrayOf("i", "water", "drink"),
        arrayOf("want", "to"),
        arrayOf("i", "want", "to", "drink", "water")
    ).also { println(it) }    //"no"
}

class CardDeck {

    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var answer: String = ""

        var j = 0
        var k = 0

        var isPossible = true

        for (i in goal.indices) {
            val str = goal[i]

            if (j < cards1.size && cards1[j] == str) {
                j++
                continue
            }

            if (k < cards2.size && cards2[k] == str) {
                k++
                continue
            }

            isPossible = false
            break
        }

        return if (isPossible) "Yes" else "No"
    }
}