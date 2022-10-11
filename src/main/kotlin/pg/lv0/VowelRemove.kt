package pg.lv0

class VowelRemove {

    fun solution(my_string: String): String {
        return my_string.replace(Regex("[aeiou]"), "")
    }
}