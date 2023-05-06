package pg.lv0

fun main() {
    ColReading().solution("ihrhbakrfpndopljhygc", 4, 2).also { println(it) }

}

class ColReading {

    fun solution(my_string: String, m: Int, c: Int): String {
        val sb = StringBuilder()
        for (i in 0 until my_string.length/m) {
            sb.append(my_string[i*m + c-1])
        }
        return sb.toString()
    }
}