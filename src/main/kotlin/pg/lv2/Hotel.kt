package pg.lv2

class Hotel {
    fun solution(book_time: Array<Array<String>>): Int {
        var answer = 0

        val max = 23 * 60 + 60 + 10
        val timeline = IntArray(max) { 0 } // start-end 까지 분라인으로 이용중이면 +1

        for (time in book_time) {
            val start = getMinutes(time[0])
            val end = getMinutes(time[1]) + 10

            for (i in start until end) {
                timeline[i]++
            }
        }

        for (i in 0 until max) {
            answer = answer.coerceAtLeast(timeline[i])
        }

        return answer
    }

    private fun getMinutes(time: String): Int {
        val token = time.split(":")
        return token[0].toInt() * 60 + token[1].toInt()
    }
}

fun main() {
    Hotel().solution(
        arrayOf(
            arrayOf("15:00", "17:00"), arrayOf("16:40", "18:20"), arrayOf("14:20", "15:20"),
            arrayOf("14:10", "19:20"), arrayOf("18:20", "21:20")
        )
    ).also { println(it) } //3

    Hotel().solution(
        arrayOf(
            arrayOf("09:10", "10:10"), arrayOf("10:20", "12:20")
        )
    ).also { println(it) } //1

    Hotel().solution(
        arrayOf(
            arrayOf("10:20", "12:30"), arrayOf("10:20", "12:30"), arrayOf("10:20", "12:30")
        )
    ).also { println(it) } //3
}