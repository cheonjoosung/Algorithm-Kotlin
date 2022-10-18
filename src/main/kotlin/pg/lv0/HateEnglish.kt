package pg.lv0

fun main() {
    HateEnglish().solution("onetwothreefourfivesixseveneightnine").run { println(this) }
    HateEnglish().solution("onefourzerosixseven").run { println(this) }
}

class HateEnglish {

    fun solution(numbers: String): Long {

        var temp = numbers

        val hashMap = hashMapOf(
            "zero" to 0,
            "one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5,
            "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9
        )

        for ((key,value) in hashMap) {
            if (temp.contains(key)) {
                temp = temp.replace(key, value.toString())
            }
        }

        return temp.toLong()
    }
}