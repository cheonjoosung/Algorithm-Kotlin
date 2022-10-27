package pg.lv0

import java.util.*

class ControlZ {

    fun solution(s: String): Int {

        val stack = Stack<Int>()
        val token = s.split(" ")
        for (str in token) {
            if (str == "Z") {
                if (stack.isNotEmpty()) stack.pop()
            } else {
                stack.push(str.toInt())
            }
        }

        return stack.sum()
    }
}