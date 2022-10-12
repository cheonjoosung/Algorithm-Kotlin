package pg.lv0

import java.lang.StringBuilder

class RemoveDuplicateString {

    fun solution(my_string: String): String {
        return my_string.toList().distinct().joinToString("")
    }
}