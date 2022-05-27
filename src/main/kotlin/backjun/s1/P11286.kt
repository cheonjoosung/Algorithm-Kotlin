package backjun.s1

import java.lang.StringBuilder
import java.util.*
import java.util.PriorityQueue




class P11286 {

    fun main() {

        val pq = PriorityQueue(Comparator label@{ o1: Int, o2: Int ->
            val abs1 = Math.abs(o1)
            val abs2 = Math.abs(o2)

            // 절댓값이 서로 같다면,,
            if (abs1 == abs2) {
                if (o1 < o2) // ex) o1=-5, o2=5
                    return@label -1 // o1를 반환해야 함 (오름차순, o1부터)
                else  // ex) o1=5, o2=-5
                    return@label 1 // o2을 반환해야 함 (내림차순으로, o2부터)
            }
            abs1 - abs2
        })

        val sc = Scanner(System.`in`)
        val sb = StringBuilder()

        var n = sc.nextInt()
        while (n-- > 0) {
            val cmd = sc.nextInt()
            if (cmd == 0) {
                if (pq.isEmpty()) sb.append(0).append('\n') else sb.append(pq.poll()).append('\n')
            } else pq.offer(cmd)
        }

        println(sb)
    }
}