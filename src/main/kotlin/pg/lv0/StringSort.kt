package pg.lv0

class StringSort {

    fun solution(my_string: String): String {
        return String(my_string.lowercase().toCharArray().sortedArray())
    }
}