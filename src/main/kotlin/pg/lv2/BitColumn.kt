package pg.lv2

import kotlin.math.pow

class BitColumn {
    fun solution(n: Int, l: Long, r: Long): Int {
        return bitColumn(n, l, r, 1)
    }

    private fun bitColumn(n: Int, s: Long, e: Long, idx: Long): Int {
        return if (n == 0) {
            1
        } else {
            var num = 0
            val part = 5.toDouble().pow(n - 1).toLong()

            for (i in 0..4) {
                if (i == 2 || e < idx + part * i || idx + part * (i + 1) - 1 < s) continue
                num += bitColumn(n - 1, s, e, idx + part * i)
            }

            num
        }
    }
}

fun main() {
    BitColumn().solution(2, 4, 17).also { println(it) } //8
}