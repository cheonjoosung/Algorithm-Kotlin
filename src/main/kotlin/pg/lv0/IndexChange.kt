package pg.lv0

import java.lang.StringBuilder

class IndexChange {

    fun solution(my_string: String, num1: Int, num2: Int): String {

        return StringBuilder(my_string).apply {
            setCharAt(num1, my_string[num2])
            setCharAt(num2, my_string[num1])
        }.toString()

    }
}