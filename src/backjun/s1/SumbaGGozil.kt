package backjun.s1

import java.util.*

class SumbaGGozil {

    fun main() {

        val sc = Scanner(System.`in`)

        val s = sc.nextInt()
        val e = sc.nextInt()

        var isVisited = BooleanArray(100001) { false }
        var answer = 0

        var q: Queue<SP> = LinkedList()
        q.add(SP(s, 0))
        /*
        x의 위치에서 갈수있는 곳 x-1, x+1, 2x  0<= [ x, x*2, x-1 ]<=100_000
         */
        while (!q.isEmpty()) {
            val item = q.poll()
            val pos = item.pos
            val cnt = item.cnt

            if (pos == e) {
                answer = cnt
                break
            }

            if (isVisited[pos]) continue //이미 지나간곳은 할 필요없음

            isVisited[pos] = true

            if (pos + 1 <= 100000) q.add(SP(pos + 1, cnt + 1))
            if (pos * 2 <= 100000) q.add(SP(pos * 2, cnt + 1))
            if (pos - 1 >= 0) q.add(SP(pos - 1, cnt + 1))
        }

        println(answer)
        sc.close()
    }
}

data class SP(var pos: Int, var cnt: Int)