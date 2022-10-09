package pg.lv0

class StringInString {

    fun solution(str1: String, str2: String): Int {
        return if (str1.contains(str2)) 1 else 2
    }
}