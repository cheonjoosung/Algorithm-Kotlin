package pg.lv0

class RankAverage {

    fun solution(score: Array<IntArray>): IntArray {
        val scoreList = score.map { it.average() }

        return scoreList.map { curScore ->
            scoreList.count { it > curScore } + 1
        }.toIntArray()
    }
}