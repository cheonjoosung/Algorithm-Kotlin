package pg.lv2

import java.util.*

class EmoticonDiscount {

    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        val rates = IntArray(emoticons.size)
        val resultHeap = PriorityQueue(compareByDescending<IntArray> { it[0] }.thenByDescending { it[1] })

        dfs(0, emoticons, rates, resultHeap, users)

        return resultHeap.peek()
    }

    private fun dfs(
        depth: Int,
        emoticons: IntArray,
        rates: IntArray,
        resultHeap: PriorityQueue<IntArray>,
        users: Array<IntArray>
    ) {
        if (depth == emoticons.size) {
            resultHeap.offer(getResult(users, emoticons, rates))
            return
        }
        for (rate in 10..40 step 10) {
            rates[depth] = rate
            dfs(depth + 1, emoticons, rates, resultHeap, users)
        }
    }

    private fun getResult(users: Array<IntArray>, emoticons: IntArray, rates: IntArray): IntArray {
        val result = intArrayOf(0, 0)

        userLoop@ for (user in users) {
            var amount = 0
            for (i in emoticons.indices) {
                if (rates[i] >= user[0]) {
                    amount += emoticons[i] * (100 - rates[i]) / 100
                    if (amount >= user[1]) {
                        result[0]++
                        continue@userLoop
                    }
                }
            }
            result[1] += amount
        }

        return result
    }
}

fun main() {
    EmoticonDiscount().solution(
        arrayOf(
            intArrayOf(40, 10000),
            intArrayOf(25, 10000)
        ),
        intArrayOf(7000, 9000)
    ).forEach { println(it) } //[1, 5400]

    EmoticonDiscount().solution(
        arrayOf(
            intArrayOf(40, 2900),
            intArrayOf(23, 10000),
            intArrayOf(11, 5200),
            intArrayOf(5, 5900),
            intArrayOf(40, 3100),
            intArrayOf(27, 9200),
            intArrayOf(32, 6900)
        ),
        intArrayOf(1300, 1500, 1600, 4900)
    ).forEach { println(it) } //[4, 13860]
}