package pg.lv0

fun main() {
    BindString().solution(arrayOf("a","bc","d","efg","hi")).also { println(it) }
}

class BindString {

    fun solution(strArr: Array<String>): Int {
        return strArr.groupBy { it.length }.maxOf { it.value.size }
    }
}