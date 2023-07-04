package pg.lv3

import java.util.PriorityQueue

class DiskController {
    fun solution(jobs: Array<IntArray>): Int {
        var time = 0
        var sum = 0
        var index = 0
        val jobSize = jobs.size

        jobs.sortWith { a,b -> a[0] - b[0]}
        val priorityQueue = PriorityQueue<IntArray>{ a, b -> a[1] - b[1]}

        jobs.sortBy { it[0] }

        while (true) {
            while (index < jobSize && time >= jobs[index][0]) {
                priorityQueue.add(jobs[index])
                index++
            }

            if (priorityQueue.isEmpty()) {
                if (index < jobSize) time = jobs[index][0]
                else break
            } else {
                val poll = priorityQueue.poll()
                sum += time - poll[0] + poll[1]
                time += poll[1]
            }
        }
        return sum / jobSize
    }
}

fun main() {
    DiskController().solution(
        arrayOf(
            intArrayOf(0, 3),
            intArrayOf(1, 9),
            intArrayOf(2, 6)
        )
    ).also { println(it) }
}