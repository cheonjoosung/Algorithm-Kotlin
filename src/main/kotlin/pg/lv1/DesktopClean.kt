package pg.lv1

fun main() {

    DesktopClean().solution(
        arrayOf(".#...", "..#..", "...#.")
    ).forEach { println(it) } //[0, 1, 3, 4]

    DesktopClean().solution(
        arrayOf("..........", ".....#....", "......##..", "...##.....", "....#.....")
    ).forEach { println(it) } //[1, 3, 5, 8]

    DesktopClean().solution(
        arrayOf(".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#....")
    ).forEach { println(it) } //[0, 0, 7, 9]

    DesktopClean().solution(
        arrayOf("..", "#.")
    ).forEach { println(it) } //[1, 0, 2, 1]
}

class DesktopClean {

    fun solution(wallpaper: Array<String>): IntArray {

        var minX = Int.MAX_VALUE
        var minY = Int.MAX_VALUE
        var maxX = Int.MIN_VALUE
        var maxY = Int.MIN_VALUE

        for (i in wallpaper.indices) {
            for (j in wallpaper[i].indices) {
                if (wallpaper[i][j] == '#') {
                    minX = i.coerceAtMost(minX)
                    minY = j.coerceAtMost(minY)

                    maxX = i.coerceAtLeast(maxX)
                    maxY = j.coerceAtLeast(maxY)
                }
            }
        }

        return intArrayOf(minX, minY, maxX+1, maxY+1)
    }
}