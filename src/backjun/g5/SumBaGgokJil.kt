package backjun.g5

import java.util.*
import javax.swing.text.html.HTML.Attribute.N

import java.util.LinkedList





class SumBaGgokJil {

    var min = 0
    fun main() {
        val sc = Scanner(System.`in`)

        val start = sc.nextInt()
        val end = sc.nextInt()

        val visit = BooleanArray(200_000) { false }
        bfs(start, end, visit)
        println(min)

        sc.close()
    }

    private fun bfs(start: Int, end: Int, visit: BooleanArray) {
        val queue: Queue<Point> = LinkedList<Point>()
        queue.add(Point(start, 0))
        while (!queue.isEmpty()) {
            val po: Point = queue.poll()
            visit[po.x] = true

            if (po.x == end) {
                min = Math.min(min, po.t)
            }

            //  0초 후에 2*X
            if (po.x * 2 <= 100000 && !visit[po.x * 2]) {
                queue.add(Point(po.x * 2, po.t))
            }
            //  1초 후에 X+1
            if (po.x + 1 <= 100000 && !visit[po.x + 1]) {
                queue.add(Point(po.x + 1, po.t + 1))
            }
            //  1초 후에 X-1
            if (po.x - 1 >= 0 && !visit[po.x - 1]) {
                queue.add(Point(po.x - 1, po.t + 1))
            }
        }
    }
}

data class Point(val x: Int, val t: Int)