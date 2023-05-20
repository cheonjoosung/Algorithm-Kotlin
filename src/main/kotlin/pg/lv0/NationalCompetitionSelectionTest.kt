package pg.lv0

fun main() {
    NationalCompetitionSelectionTest()
        .solution(intArrayOf(3, 7, 2, 5, 4, 6, 1), booleanArrayOf(false, true, true, true, true, false, false))
        .also { println(it) }

    NationalCompetitionSelectionTest()
        .solution(intArrayOf(1, 2, 3), booleanArrayOf(true, true, true))
        .also { println(it) }

    NationalCompetitionSelectionTest()
        .solution(intArrayOf(6, 1, 5, 2, 3, 4), booleanArrayOf(true, false, true, false, false, true))
        .also { println(it) }
}

class NationalCompetitionSelectionTest {

    fun solution(rank: IntArray, attendance: BooleanArray): Int {
        rank.mapIndexed { i, v -> i to v }
            .filter { attendance[it.first] }
            .sortedBy { it.second }
            .also { result ->
                return result[0].first * 10000 + result[1].first * 100 + result[2].first
            }

    }

}