package pg.lv2

class DeliveryAndGet {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var deliver = 0
        var pickUp = 0
        var answer = 0L

        for (i in n-1 downTo 0) {
            if (deliveries[i] != 0 || pickups[i] != 0) {
                var cnt = 0

                while (deliver < deliveries[i] || pickUp < pickups[i]) {
                    cnt++
                    deliver += cap
                    pickUp += cap
                }

                deliver -= deliveries[i];
                pickUp -= pickups[i];
                answer += (i+1).toLong() * cnt * 2L
            }
        }

        return answer
    }
}

fun main() {
    DeliveryAndGet().solution(4, 5, intArrayOf(1, 0, 3, 1, 2), intArrayOf(0, 3, 0, 4, 0))
        .also { println(it) } //16
    DeliveryAndGet().solution(2, 7, intArrayOf(1, 0, 2, 0, 1, 0, 2), intArrayOf(0, 2, 0, 1, 0, 2, 0))
        .also { println(it) } //30
}
