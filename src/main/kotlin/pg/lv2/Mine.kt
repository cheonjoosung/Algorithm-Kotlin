package pg.lv2

class Mine {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var modifiedMinerals = minerals.copyOf()
        if (picks.sum() * 5 < modifiedMinerals.size) {
            modifiedMinerals = modifiedMinerals.sliceArray(0 until picks.sum() * 5)
        }

        val counted = scanMinerals(modifiedMinerals)
        return calculateFatigue(counted, picks)
    }

    private fun scanMinerals(minerals: Array<String>): List<List<Int>> {
        var i = 0
        val counted = mutableListOf<List<Int>>()
        while (i < minerals.size) {
            val target = if (i + 5 < minerals.size) {
                minerals.copyOfRange(i, i + 5)
            } else {
                minerals.copyOfRange(i, minerals.size)
            }
            val dias = target.count { it == "diamond" }
            val irons = target.count { it == "iron" }
            val stones = target.count { it == "stone" }
            counted.add(listOf(dias, irons, stones))
            i += 5
        }
        counted.sortWith(compareByDescending<List<Int>> { it[0] }.thenByDescending { it[1] })
        return counted
    }

    private fun calculateFatigue(counted: List<List<Int>>, picks: IntArray): Int {
        var result = 0
        for (target in counted) {
            result += when {
                picks[0] > 0 -> {
                    picks[0] -= 1
                    target.sum()
                }
                picks[1] > 0 -> {
                    picks[1] -= 1
                    target[0] * 5 + target[1] + target[2]
                }
                picks[2] > 0 -> {
                    picks[2] -= 1
                    target[0] * 25 + target[1] * 5 + target[2]
                }
                else -> break
            }
        }
        return result
    }
}

fun main() {

    Mine().solution(
        intArrayOf(1, 3, 2),
        arrayOf("diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone")
    ).also { println(it) } //12
    Mine().solution(
        intArrayOf(0, 1, 1),
        arrayOf(
            "diamond",
            "diamond",
            "diamond",
            "diamond",
            "diamond",
            "iron",
            "iron",
            "iron",
            "iron",
            "iron",
            "diamond"
        )
    ).also { println(it) } //50
}