package pg.lv0

fun main() {
    ArrayCutting().solution("abc1Addfggg4556b", 6).forEach { println(it) }
    ArrayCutting().solution("abcdef123", 3).forEach { println(it) }
}

class ArrayCutting {

    fun solution(my_str: String, n: Int): Array<String> {
        val size = if (my_str.length % n == 0) my_str.length / n else my_str.length / n + 1

        val answer = Array(size) { "" }

        for (i in 0 until size) {
            //println("${n*i} ${n*i+n} ${Math.min(n*i+n, my_str.length)}")
            answer[i] = my_str.substring(n*i, Math.min(n*i+n, my_str.length))
        }

        return answer
    }
}