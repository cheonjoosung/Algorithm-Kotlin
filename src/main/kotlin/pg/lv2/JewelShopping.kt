package pg.lv2

fun main() {
    JewelShopping().solution(arrayOf("DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"))
        .also { println("${it[0]} ${it[1]}") } //3 7
    JewelShopping().solution(arrayOf("AA", "AB", "AC", "AA", "AC")).also { println("${it[0]} ${it[1]}") } // 1 3
    JewelShopping().solution(arrayOf("XYZ", "XYZ", "XYZ")).also { println("${it[0]} ${it[1]}") } // 1 1
    JewelShopping().solution(arrayOf("ZZZ", "YYY", "NNNN", "YYY", "BBB")).also { println("${it[0]} ${it[1]}") } // 1 5
}

class JewelShopping {

    fun solution(gems: Array<String>): IntArray {
        val answer = intArrayOf(0, 0)

        val set = hashSetOf<String>()
        val map = hashMapOf<String, Int>()

        gems.forEach { set.add(it) }

        var destination = Int.MAX_VALUE
        var start = 0
        var end = 0

        while (true) {

            if (set.size == map.size) { // 보석 모두 포함된 경우
                map[gems[start]] = map[gems[start]]?.minus(1) ?: 0

                if (map[gems[start]] == 0) map.remove(gems[start])

                start++
            } else if (end == gems.size) { // 배열 범위 체크
                break
            } else { // 보석 모두 포함되지 않은 경우
                map[gems[end]] = map.getOrDefault(gems[end], 0) + 1
                end++
            }

            if (set.size == map.size) { // 범위 변경
                if (end - start <destination) {
                    destination = end - start
                    answer[0] = start + 1
                    answer[1] = end
                }
            }
        }

        return answer
    }
}