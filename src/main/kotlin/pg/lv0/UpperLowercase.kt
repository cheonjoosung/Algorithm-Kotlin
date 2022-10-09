package pg.lv0

class UpperLowercase {

    fun solution(my_string: String): String {
        return my_string.map { if (it.isLowerCase()) it.uppercase() else it.lowercase() }.joinToString("")
    }
}