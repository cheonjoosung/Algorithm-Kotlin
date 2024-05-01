package pg.lv3

/**
 * 모든 사람을 심사하는 데 걸리는 시간의 최소/최대 시간을 설정
 * mid 값을 설정해서 각 심사관들이 심사할 수 있는 인원의 수 구하면서 mid/max 값 조절
 */
fun solution(n: Int, times: IntArray): Long {
    var min: Long = n.toLong() / times.size * times.minOrNull()!!.toLong()
    var max: Long = times.maxOrNull()!!.toLong() * n

    while (min <= max) {
        val mid = (min + max) / 2

        //ㅎㅕㄴ재 시간 안에 n 명의 사람을 모두 심사할 수 있는지
        var sum = 0L
        times.forEach { sum += mid / it }

        // 모두 심사 가능한 경우, 더 짧은 시간으로 가능한지 확인
        // 모두 심사 불가능한 경우, 더 많은 시간 필요
        if (sum >= n) max = mid - 1
        else min = mid + 1
    }

    return max + 1
}

fun main() {
    solution(6, intArrayOf(7, 10)).also { println(it) }
}