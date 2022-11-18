package pg.lv1

fun main() {
    Babbling().solution(arrayOf("aya", "yee", "u", "maa")).also { println(it) } //1
    Babbling().solution(arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa")).also { println(it) } //2
}

class Babbling {

    fun solution(babbling: Array<String>): Int {

        var answer: Int = 0

        for (word in babbling) {

            if (word.contains("ayaaya") || word.contains("yeye") || word.contains("woowoo") || word.contains("mama"))
                continue

            val str = word
                .replace("aya", " ")
                .replace("ye", " ")
                .replace("woo", " ")
                .replace("ma", " ")
                .replace(" ", "")

            if (str.isEmpty()) answer++
        }


        return answer
    }
}