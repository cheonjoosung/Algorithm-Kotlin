package pg.lv2

import java.util.*

fun main() {
    NumberConverter().solution(10, 40, 5).also { println(it) } // 2
    NumberConverter().solution(10, 40, 30).also { println(it) } // 1
    NumberConverter().solution(2, 5, 4).also { println(it) } // -1
}

class NumberConverter {

    fun solution(x: Int, y: Int, n: Int): Int {
        if (x == y) return 0

        val arr = IntArray(1_000_000 + 1) { Int.MAX_VALUE }

        val q: Queue<Num> = LinkedList()
        q.add(Num(x, 0))

        while (q.isNotEmpty()) {
            val num = q.poll()

            val n0 = num.n
            val cnt = num.cnt

            val nx1 = n0 + n
            val nx2 = n0 * 2
            val nx3 = n0 * 3

            if (nx1 <= 1_000_000) {
                if (arr[nx1] > cnt + 1) {
                    arr[nx1] = cnt + 1
                    q.add(Num(nx1, cnt + 1))
                }
            }

            if (nx2 <= 1_000_000) {
                if (arr[nx2] > cnt + 1) {
                    arr[nx2] = cnt + 1
                    q.add(Num(nx2, cnt + 1))
                }
            }

            if (nx3 <= 1_000_000) {
                if (arr[nx3] > cnt + 1) {
                    arr[nx3] = cnt + 1
                    q.add(Num(nx3, cnt + 1))
                }
            }
        }

        return if (arr[y] == Int.MAX_VALUE) -1 else arr[y]
    }
}

data class Num(val n: Int, val cnt: Int)