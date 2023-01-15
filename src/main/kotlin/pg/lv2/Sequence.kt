package pg.lv2

class Sequence {

    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
        val answer = DoubleArray(ranges.size)

        // 콜라츠 추측에의해, k가 몇 번만에 1이 되는지 확인
        val cnt: Int = count(k)
        val yValue = DoubleArray(cnt + 1)
        yValue[0] = k.toDouble()
        for (i in 1 until cnt + 1) {
            val pre = yValue[i - 1]
            yValue[i] = calYValue(pre)
        }

        // 사다리꼴 넓이
        val area = DoubleArray(cnt + 1)
        for (i in 1 until cnt + 1) {
            area[i] = (yValue[i - 1] + yValue[i]) / 2
        }

        // 넓이 누적합
        val prefixSum = DoubleArray(cnt + 1)
        prefixSum[1] = area[1]
        for (i in 2 until cnt + 1) {
            prefixSum[i] = area[i] + prefixSum[i - 1]
        }
        for (i in ranges.indices) {
            val s = ranges[i][0]
            val e = cnt + ranges[i][1]

            // s부터 e까지 정적분(넓이)
            if (e > s) {
                val `val` = prefixSum[e] - prefixSum[s]
                val str = String.format("%.1f", `val`)
                answer[i] = str.toDouble()
            } else if (s > e) {
                answer[i] = -1.0
            } else {
                answer[i] = 0.0
            }
        }
        return answer
    }

    private fun count(_y: Int): Int {
        var y = _y
        var cnt = 0
        while (y > 1) {
            y = if (y % 2 == 0) y / 2 else y * 3 + 1
            cnt++
        }
        return cnt
    }

    private fun calYValue(pre: Double): Double {
        return if (pre % 2 == 0.0) {
            pre / 2
        } else {
            3 * pre + 1
        }
    }
}
