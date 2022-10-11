package pg.lv0

import java.lang.StringBuilder

class ScissorsRockPaper {

    fun solution(rsp: String): String {
        val sb = StringBuilder()

        rsp.forEach {
            when (it) {
                '0' -> sb.append("5")
                '2' -> sb.append("0")
                else -> sb.append("2")
            }
        }

        return sb.toString()
    }
}