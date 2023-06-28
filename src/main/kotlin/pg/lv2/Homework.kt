package pg.lv2

import java.util.*


class Homework {

    fun solution(plans: Array<Array<String>>): List<String> {
        val answer = mutableListOf<String>()

        // 시작시간 순으로 정렬하여 저장
        val pq = PriorityQueue { o1: Task, o2: Task -> o1.start - o2.start }

        for (i in plans.indices) {
            val name = plans[i][0]

            val str = plans[i][1].split(":")
            val h = str[0].toInt()
            val m = str[1].toInt()
            val start = h * 60 + m

            val time = plans[i][2].toInt()

            pq.add(Task(name, start, time))
        }

        // 잠시 멈춘 과제를 저장
        val remainingTasks = Stack<Task>()

        while (!pq.isEmpty()) {
            val currentTask = pq.poll()
            val curName = currentTask.name
            val curStart = currentTask.start
            val curPlaytime: Int = currentTask.playTime

            // 현재 시각
            var currentTime = curStart

            // 새로운 과제가 남아있는 경우(진행중이던 과제 제외)
            if (!pq.isEmpty()) {
                val (_, start) = pq.peek()

                // 지금 과제를 끝내고도 다음 과제 시작까지 시간이 남는 경우
                if (currentTime + curPlaytime < start) {
                    answer.add(curName)
                    currentTime += curPlaytime

                    // 잠시 멈춘 과제가 있는 경우, 남는 시간동안 멈췄던 과제 해결
                    while (!remainingTasks.isEmpty()) {
                        val rem = remainingTasks.pop()

                        // 다음 새로운 과제 시작전까지 다 끝낼수 있는 경우
                        if (currentTime + rem.playTime <= start) {
                            currentTime += rem.playTime
                            answer.add(rem.name)
                            continue
                        } else {
                            val t: Int = rem.playTime - (start - currentTime)
                            // 추가로 한 시간만 빼서 멈춘 과제 목록에 다시 추가
                            remainingTasks.push(Task(rem.name, playTime = t))
                            break
                        }
                    }
                } else if (curStart + curPlaytime == start) {
                    answer.add(curName)
                    continue
                } else {
                    val t = start - currentTime
                    remainingTasks.push(Task(curName, playTime = curPlaytime - t))
                }
            } else {
                // 남아있는 과제(잠시 멈춘 과제)도 없는 경우
                if (remainingTasks.isEmpty()) {
                    currentTime += curPlaytime
                    answer.add(curName)
                } else {
                    answer.add(curName) // 새로운 과제부터 먼저 해결

                    // 남아있는 과제들을 정해진 순서대로 끝내면 됨
                    while (!remainingTasks.isEmpty()) {
                        val (name) = remainingTasks.pop()
                        answer.add(name)
                    }
                }
            }
        }


        return answer.toList()
    }
}

data class Task(val name: String, val start: Int = 0, val playTime: Int)

fun main() {
    Homework().solution(
        arrayOf(
            arrayOf("korean", "11:40", "30"), arrayOf("english", "12:10", "20"), arrayOf("math", "12:30", "40")
        )
    ).forEach { println(it) } //"korean", "english", "math"

    Homework().solution(
        arrayOf(
            arrayOf("science", "12:40", "50"),
            arrayOf("music", "12:20", "40"),
            arrayOf("history", "14:00", "30"),
            arrayOf("computer", "12:30", "100")
        )
    ).forEach { println(it) } //"science", "history", "computer", "music"

    Homework().solution(
        arrayOf(
            arrayOf("aaa", "12:00", "20"), arrayOf("bbb", "12:10", "30"), arrayOf("ccc", "12:40", "10")
        )
    ).forEach { println(it) } //"bbb", "ccc", "aaa"]
}
