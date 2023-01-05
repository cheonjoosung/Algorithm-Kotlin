package pg.lv1

fun main() {
    PrivacyInfo().solution(
        "2022.05.19",
        arrayOf("A 6", "B 12", "C 3"),
        arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")
    ).forEach { print("$it ") } // 1 3
    println()
    PrivacyInfo().solution(
        "2020.01.01",
        arrayOf("Z 3", "D 5"),
        arrayOf("2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z")
    ).forEach { print("$it ") } // 1 4 5
}

class PrivacyInfo {

    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val answer = mutableListOf<Int>()

        val todayTotal = totalDay(today)
        val map = hashMapOf<String, Int>()

        for (i in terms.indices) {
            val token = terms[i].split(" ")
            map[token[0]] = token[1].toInt()
        }

        for (i in privacies.indices) {
            val token = privacies[i].split(" ")

            val date = token[0]
            val type = token[1]

            val dateTotal = totalDay(date)
            val month = map[type] ?: 0
            val changedDay = month * 28

            if (todayTotal >= (dateTotal + changedDay)) {
                answer.add(i+1)
            }
        }

        return answer.toIntArray()
    }

    private fun totalDay(todayTotal: String): Int {

        var sum = 0
        val token = todayTotal.split(".")
        val y = token[0]
        val m = token[1]
        val d = token[2]

        sum += y.toInt() * 12 * 28
        sum += (m.toInt() - 1) * 28
        sum += d.toInt()

        return sum
    }
}