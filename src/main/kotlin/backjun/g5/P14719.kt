package backjun.g5

import java.util.*

class P14719 {


    fun main() {

        val sc = Scanner(System.`in`)
        val r = sc.nextInt()
        val c = sc.nextInt()

        var answer = 0
        val map = IntArray(c) { 0 }

        for (i in 0 until c) map[i] = sc.nextInt()

        for (i in 1 until c) {
            val current = map[i]
            var leftMax = current
            var rightMax = current

            for (j in i - 1 downTo 0) { // 왼쪽 최대 벽높이
                if (map[j] > current) leftMax = Math.max(leftMax, map[j])
            }

            for (j in i + 1 until c) { //오른쪽 최대 벽높이
                if (map[j] > current) rightMax = Math.max(rightMax, map[j])
            }

            if (Math.min(leftMax, rightMax) > current) { // 현재 벽보다 높은 벽이 양쪽에 있는 경우
                answer += (Math.min(leftMax, rightMax) - map[i])
            }

        }

        println(answer)
        sc.close()
    }

}