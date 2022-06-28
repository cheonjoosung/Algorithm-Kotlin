package backjun.g5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    // N과 M 그리고 각 입국 심사대에서 걸리는 시간을 arr 배열에 데이터를 입력받음

    val data = br.readLine().split(" ").toTypedArray()
    val n = data[0].toInt()
    val m = data[1].toInt()
    val arr = IntArray(n)

    // 그리고 가장 입국 심사대에서 오래 걸리는 시간을 max_value 로 구함
    var max_value = 0
    for (i in 0 until n) {
        arr[i] = br.readLine().toInt()
        max_value = Math.max(max_value, arr[i])
    }

    var left = 0L
    var right = max_value * 1000000000L

    var ans = 0L
    while (left <= right) {
        val mid = (left + right) / 2
        // mid초 일 때 각 입국 심사대에서 보낼 수 있는 수를 카운트 해줌
        var cnt: Long = 0
        for (i in 0 until n) {
            cnt += mid / arr[i]
        }
        // 비교 후 탐색 범위 변경
        if (cnt >= m) {
            ans = mid
            right = mid - 1
        } else if (cnt < m) {
            left = mid + 1
        }
    }

    println(ans)
}
