package pg.lv1

class PainOver {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0

        val list = section.toMutableList()

        while (list.size != 0) {
            val start = list.first()
            val end = start + m

            list.removeIf { it in start until end }
            answer++
        }

        return answer
    }
}