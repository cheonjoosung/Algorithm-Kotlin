package pg.lv0

class HiddenNumberAdd {

    fun solution(my_string: String): Int {
        return my_string.filter(Char::isDigit).map { c -> c.digitToInt() }.sum()
    }
}