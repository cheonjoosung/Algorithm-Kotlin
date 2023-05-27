package pg.lv1

fun main() {
    RunRace().solution(
        arrayOf("mumu", "soe", "poe", "kai", "mine"),
        arrayOf("kai", "kai", "mine", "mine")
    ).forEach {
        println(it)
    } //"mumu", "kai", "mine", "soe", "poe"
}

class RunRace {

    fun solution(players: Array<String>, callings: Array<String>): Array<String> {

        val rankMap = mutableMapOf<String, Int>()
        players.forEachIndexed { index, s -> rankMap[s] = index }

        callings.forEachIndexed { index, s ->
            val callRank = rankMap[s] ?: 0
            val frontPlayer = players[callRank - 1]

            players[callRank - 1] = s
            players[callRank] = frontPlayer

            rankMap[s] = callRank - 1
            rankMap[frontPlayer] = callRank
        }


        return players
    }
}