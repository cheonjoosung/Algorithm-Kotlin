package pg.lv2

class AlonePlay {
    fun solution(cards: IntArray): Int {
        val boxes = mutableMapOf<Int, Int>()
        cards.forEachIndexed { index, card ->
            boxes[index + 1] = card
        }

        val groups = mutableListOf<Int>()
        while (boxes.isNotEmpty()) {
            val visited = mutableSetOf<Int>()

            var pos = boxes.keys.first()
            while (pos !in visited) {
                visited.add(pos)
                val temp = boxes[pos]
                boxes.remove(pos)
                if (temp != null) {
                    pos = temp
                }
            }
            groups.add(visited.size)
        }
        groups.sortDescending()
        return if (groups.size > 1) groups[0] * groups[1] else 0
    }


}

fun main() {
    AlonePlay().solution(intArrayOf(8, 6, 3, 7, 2, 5, 1, 4)).also { println(it) }
}