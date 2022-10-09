package pg.lv0

class StringRepeat {

    fun solution(my_string: String, n: Int): String {
        return my_string.map { it.toString().repeat(n) }.joinToString()
    }
}