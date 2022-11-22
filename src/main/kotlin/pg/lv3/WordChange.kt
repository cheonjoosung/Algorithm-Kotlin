package pg.lv3

fun main() {
    WordChange().solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog")).also { println(it) } //4
    WordChange().solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log")).also { println(it) } // 0
}

class WordChange {

    var answer = Int.MAX_VALUE

    fun solution(begin: String, target: String, words: Array<String>): Int {

        val size = words.size
        val visit = BooleanArray(size) { false }

        dfs(begin, target, 0, 0, words, visit)

        return if (answer == Int.MAX_VALUE) 0 else answer
    }

    private fun dfs(begin: String, target: String, idx:Int, count: Int, words: Array<String>, visit: BooleanArray) {

        if (begin == target) {
            answer = Math.min(answer, count)
            return
        }

        if (idx == words.size) return

        for (i in words.indices) {

            if (visit[i]) continue

            if (diffCount(begin, words[i]) == 1) {
                visit[i] = true
                dfs(words[i], target, idx+1,count + 1, words, visit)
                visit[i] = false
            }
        }
    }

    private fun diffCount(before: String, after: String): Int {
        var count = 0

        for (i in before.indices) {
            if (before[i] != after[i]) count++
        }

        return count
    }
}