package pg.lv2

fun solution(points: Array<IntArray>, routes: Array<IntArray>): Int {

    val map = Array(101) { Array(101) { hashMapOf<Int, Int>() } }

    for (route in routes) {
        var time = 0

        for (i in 1 until route.size) {
            var (cx, cy) = points[route[i - 1] - 1]
            var (ex, ey) = points[route[i] - 1]

            while (cx != ex || cy != ey) {
                map[cx][cy][time] = (map[cx][cy][time] ?: 0) + 1

                if (cx != ex) {
                    if (cx > ex) cx--
                    else cx++
                } else {
                    if (cy > ey) cy--
                    else cy++
                }

                time++
            }
        }

        val (fx, fy) = points[route.last() - 1]
        map[fx][fy][time] = (map[fx][fy][time] ?: 0) + 1
    }

    var collisions = 0
    for (x in 1..100) {
        for (y in 1..100) {
            collisions += map[x][y].values.count { it > 1 }
        }
    }
    return collisions
}