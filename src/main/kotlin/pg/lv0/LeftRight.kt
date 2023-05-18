package pg.lv0

fun main() {
    LeftRight().solution(arrayOf("u","r","l","r")).forEach { println(it) }
    LeftRight().solution(arrayOf("l")).forEach { println(it) }
}

class LeftRight {
    fun solution(str_list: Array<String>): Array<String> {

        var startIndex = 0
        var endIndex = 0
        val size: Int = str_list.size
        for (i in 0 until size) {
            val ch = str_list[i]
            if (ch == "l") {
                startIndex = 0
                endIndex = i
                break
            }
            if (ch == "r") {
                startIndex = i + 1
                endIndex = size
                break
            }
        }
        val answer = Array(endIndex - startIndex){ ""}

        for (i in startIndex until endIndex) {
            answer[i - startIndex] = str_list[i]
        }

        return answer
    }
}