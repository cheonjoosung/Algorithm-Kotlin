package pg.lv3

class Hanoi {
    fun solution(n: Int): Array<IntArray> {
        val answer = mutableListOf<IntArray>()
        hanoi("1", "2", "3", n, answer)
        return answer.toTypedArray()
    }

    fun hanoi(start: String, to: String, end: String, n: Int, answer:MutableList<IntArray>) {

        if (n == 1) {
            answer.add(intArrayOf(start.toInt(), end.toInt()))
            return
        }

        hanoi(start, end, to, n-1, answer)
        answer.add(intArrayOf(start.toInt(), end.toInt()))
        hanoi(to, start, end, n-1, answer)
    }
}