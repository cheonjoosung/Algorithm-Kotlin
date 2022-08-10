package pg.lv2

fun main() {


}

fun solution(word: String): Int {
    var answer = 0

    val number = hashMapOf<Char, Int>().apply {
        put('A', 0)
        put('E', 1)
        put('I', 2)
        put('O', 3)
        put('U', 4)
    }

    // 각 패턴마다 5개씩이 있고 공백이 오는 경우가 있어서 + 1
    val array = arrayOf(781, 156, 31, 6, 1)

    for (i in word.indices) {
        number[word[i]]?.times(array[i])?.plus(1)?.let {
            answer += it
        }
    }

    return answer
}

class Solution {
    val arr = arrayOf("A", "E", "I", "O", "U")
    val result = mutableListOf<String>()

    fun solution(word: String): Int {
        dfs("")
        result.forEachIndexed { idx, s ->
            if(s == word) return idx
        }
        return -1
    }

    fun dfs(str: String) {
        if(str.length > 5) return
        result.add(str)
        for(a in arr) {
            dfs(str + a)
        }
    }
}