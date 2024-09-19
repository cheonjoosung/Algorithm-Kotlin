package pg.lv1

fun main() {
    MoviePlayer().solution("34:33", "13:00", "00:55", "02:55", arrayOf("next", "prev")).also { println(it) }
    MoviePlayer().solution("10:55", "00:05", "00:15", "06:55", arrayOf("prev", "next", "next")).also { println(it) }
    MoviePlayer().solution("07:22", "04:05", "00:15", "04:07", arrayOf("next")).also { println(it) }
    MoviePlayer().solution("30:00", "00:08", "00:00", "00:05", arrayOf("prev")).also { println(it) }
    MoviePlayer().solution("34:33", "09:50", "10:00", "13:00", arrayOf("next", "next", "next", "prev"))
        .also { println(it) }
}

class MoviePlayer {
    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {

        val videoLength = video_len.toSec()
        val opStart = op_start.toSec()
        val opEnd = op_end.toSec()
        var currentTime = pos.toSec()

        currentTime = isOpRange(currentTime, opStart..opEnd)

        for (command in commands) {
            currentTime = when (command) {
                "prev" -> {
                    if (currentTime - 10 < 0) 0 else currentTime - 10
                }

                else -> {
                    if (currentTime + 10 > videoLength) videoLength else currentTime + 10
                }
            }

            currentTime = isOpRange(currentTime, opStart..opEnd)
        }


        return timeToString(currentTime)
    }

    private fun isOpRange(posTime: Int, opRange: IntRange): Int {
        return if (posTime in opRange) opRange.last else posTime
    }


    private fun timeToString(posTime: Int): String {
        return String.format("%02d:%02d", posTime / 60, posTime % 60)
    }

    private fun String.toSec(): Int = this.split(":").let {
        it[0].toInt() * 60 + it[1].toInt()
    }
}