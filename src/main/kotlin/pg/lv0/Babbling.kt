package pg.lv0

fun main() {
    Babbling().solution(arrayOf("aya", "yee", "u", "maa", "wyeoo")).also { println(it) }
    Babbling().solution(arrayOf("ayaye", "uuuma", "ye", "yemawoo", "ayaa")).also { println(it) }
}

class Babbling {

    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0

        val based = arrayOf("aya", "ye", "woo", "ma")

        for (i in babbling.indices) {
            var str = babbling[i]

            for (j in based.indices) {
                if (str.contains(based[j])) {
                    str = str.replace(based[j], " ")
                }
            }

            //println("${babbling[i]} -> $str")
            if (str.replace(" ", "") == "") {
                answer++
            }
        }

        return answer
    }

    fun solution2(babbling: Array<String>): Int {
        val regex = "aya|ye|woo|ma".toRegex()

        return babbling.map { it.replace(regex, "") }
            .filter { it.isEmpty() }
            .count()
    }
}