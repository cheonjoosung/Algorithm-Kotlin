package pg.lv2

import java.util.*

class RotateBracket {

    fun solution(s: String): Int {
        var answer: Int = 0

        val size = s.length

        for (i in 0 until size) {
            val tempStr = s.substring(i, size).plus(s.substring(0, i))

            if (isCorrectBracket(tempStr, size))
                answer++
        }

        return answer
    }

    private fun isCorrectBracket(str: String, size: Int): Boolean {

        val list = mutableListOf<Char>()

        for (i in 0 until size) {

            when (val ch = str[i]) {
                '{', '[', '(' -> { // push
                    list.add(ch)
                }
                else -> { // pop
                    if (list.isEmpty()) {
                        return false
                    } else {
                        val lastIdx = list.lastIndex

                        val tempCh = when (ch) {
                            ']' -> '['
                            '}' -> '{'
                            else -> '('
                        }

                        if (list[lastIdx] == tempCh)
                            list.removeAt(lastIdx)
                        else
                            return false
                    }
                }
            }
        }

        return list.size == 0
    }
}