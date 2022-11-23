package pg.lv3

import java.util.HashSet

import java.util.ArrayList
import java.util.regex.Pattern


fun main() {
    BadUser().solution(
        arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"),
        arrayOf("fr*d*", "abc1**")
    ).also { println(it) } //2


    BadUser().solution(
        arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"),
        arrayOf("*rodo", "*rodo", "******")
    ).also { println(it) } //2

    BadUser().solution(
        arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"),
        arrayOf("fr*d*", "*rodo", "******", "******")
    ).also { println(it) } //3
}

class BadUser {

    var bannedId = mutableListOf<List<String>>()
    var result = mutableSetOf(setOf<String>())
    var userCnt = 0
    var bannedCnt: Int = 0

    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        userCnt = user_id.size
        bannedCnt = banned_id.size
        bannedId = ArrayList()
        result = HashSet()

        for (id in banned_id)
            bannedId.add(getIdList(user_id, id))

        dfs(0, HashSet())
        return result.size
    }

    private fun getIdList(user_id: Array<String>, id: String): List<String> {
        val pattern = id.replace('*', '.')
        val res: MutableList<String> = ArrayList()
        for (next in user_id) {
            if (Pattern.matches(pattern, next)) res.add(next)
        }
        return res
    }

    private fun dfs(depth: Int, tmpSet: MutableSet<String>) {
        if (depth == bannedCnt) {
            result.add(HashSet(tmpSet))
            return
        }
        for (bannedId in bannedId[depth]) {
            if (!tmpSet.contains(bannedId)) {
                tmpSet.add(bannedId)
                dfs(depth + 1, tmpSet)
                tmpSet.remove(bannedId)
            }
        }
    }
}