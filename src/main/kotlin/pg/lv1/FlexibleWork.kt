package pg.lv1


fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
    var answer = 0

    for (i in schedules.indices) {
        val timelog = timelogs[i]
        val schedule = getSchedule(schedules[i])

        var day = startday

        for (t in timelog) {
            if (day % 7 == 0 || day % 7 == 6) {
                day++
                continue
            }

            if (t > schedule) {
                break
            }

            day++
        }

        if (day == startday + 7) {
            answer++
        }
    }

    return answer
}

private fun getSchedule(schedule: Int): Int {
    var schedule = schedule
    schedule += 10

    if (schedule % 100 >= 60) {
        val h = (schedule / 100) + 1
        val m = (schedule % 100) - 60
        schedule = (h * 100) + m
    }
    return schedule
}

fun main() {
    /*
    [700, 800, 1100]	[[], [], []]	5	3
[730, 855, 700, 720]	[[710, 700, 650, 735, 700, 931, 912], [908, 901, 805, 815, 800, 831, 835], [705, 701, 702, 705, 710, 710, 711], [707, 731, 859, 913, 934, 931, 905]]	1	2
     */
    val schedules = intArrayOf(700, 800, 1100)
    val timelogs = arrayOf(
        intArrayOf(710, 2359, 1050, 700, 650, 631, 659),
        intArrayOf(800, 801, 805, 800, 759, 810, 809),
        intArrayOf(1105, 1001, 1002, 600, 1059, 1001, 1100)
    )
    solution(schedules, timelogs, 5).also { println(it) } // 3
}