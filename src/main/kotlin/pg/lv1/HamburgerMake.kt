package pg.lv1

fun main() {
    HamburgerMake().solution(intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1)).also { println(it) } //2
    HamburgerMake().solution(intArrayOf(1, 3, 2, 1, 2, 1, 3, 1, 2)).also { println(it) } //0
}

class HamburgerMake {

    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0

        val sb = StringBuilder()

        for (item in ingredient) {
            sb.append('0' + item)

            if (sb.length >= 4 && sb.substring(sb.length - 4) == "1231") {
                sb.setLength(sb.length - 4)
                answer++
            }
        }
        return answer
    }
}