package pg.lv3

import java.util.*

fun main() {

    val d = DoublePriorityQueue()

    val a1 = arrayOf("I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1")
    val a2 = arrayOf("I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333")

    d.solution(a1).forEach { print("$it ") }
    d.solution(a2).forEach { print("$it ") }
}

class DoublePriorityQueue {

    fun solution(operations: Array<String>): IntArray {
        val answer = IntArray(2)

        //최소 힙, 최대 힙
        val pq = PriorityQueue<Int>()
        val maxPq = PriorityQueue<Int>(reverseOrder())

        for (op in operations) {
            val st = StringTokenizer(op)
            val judge = st.nextToken()
            val value = st.nextToken().toInt()

            //빈 큐에 데이터를 삭제 요청 경우 연산 무시
            if (pq.size < 1 && judge == "D") continue

            //삽입 시 최소 힙, 최대 힙에 value 넣기
            if (judge == "I") {
                pq.offer(value)
                maxPq.offer(value)
                continue
            }

            //나머지 경우는 D이면서 value값이 1인지 -1인지 이므로
            //0보다 작은 경우 최소 힙에서 poll후 최대힙에서 해당 원소 삭제
            if (value < 0) {
                val min = pq.poll()
                maxPq.remove(min)
                continue
            }

            //최대 힙에서 poll후 최소힙에서 해당 원소 삭제
            val max = maxPq.poll()
            pq.remove(max)
        }

        if (pq.size > 0) {
            answer[0] = maxPq.poll()
            answer[1] = pq.poll()
        }

        return answer
    }
}