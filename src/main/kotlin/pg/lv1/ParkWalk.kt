package pg.lv1

fun main() {
    ParkWalk().solution(
        arrayOf("SOO", "OOO", "OOO"),
        arrayOf("E 2", "S 2", "W 1")
    ).forEach { println(it) } // 2,1

    ParkWalk().solution(
        arrayOf("SOO", "OXX", "OOO"),
        arrayOf("E 2", "S 2", "W 1")
    ).forEach { println(it) } // 0,1

    ParkWalk().solution(
        arrayOf("OSO", "OOO", "OXO", "OOO"),
        arrayOf("E 2", "S 3", "W 1")
    ).forEach { println(it) } // 0,0
}

class ParkWalk {

    var startX = 0
    var startY = 0

    var row = 0
    var col = 0

    fun solution(park: Array<String>, routes: Array<String>): IntArray {

        val map = Array(park.size) { IntArray(park[0].length) { 0 } }
        park.forEachIndexed { i, s ->
            s.forEachIndexed { j, c ->
                when (c) {
                    'S' -> {
                        startX = i
                        startY = j
                    }
                    'X' -> map[i][j] = -1
                }
            }
        }

        row = map.size
        col = map[0].size

        routes.forEach {
            val split = it.split(" ")

            when (split[0]) {
                "N" -> { //i--
                    if ((checkOutSide(split[0], split[1].toInt()) && checkObstacle(split[0], split[1].toInt(), map))) {
                        startX -= split[1].toInt()
                    }
                }
                "S" -> { //i++
                    if ((checkOutSide(split[0], split[1].toInt()) && checkObstacle(split[0], split[1].toInt(), map))) {
                        startX += split[1].toInt()
                    }
                }
                "W" -> { //j--
                    if ((checkOutSide(split[0], split[1].toInt()) && checkObstacle(split[0], split[1].toInt(), map))) {
                        startY -= split[1].toInt()
                    }
                }
                "E" -> { //j++
                    if ((checkOutSide(split[0], split[1].toInt()) && checkObstacle(split[0], split[1].toInt(), map))) {
                        startY += split[1].toInt()
                    }
                }
            }
        }

        return intArrayOf(startX, startY)
    }

    private fun checkObstacle(routes: String, moveCount: Int, map: Array<IntArray>): Boolean {
        when (routes) {
            "N" -> {
                (1..moveCount).forEach { it ->
                    if (startX - it >= 0 && map[startX - it][startY] == -1) return false
                }
            }
            "S" -> {
                (1..moveCount).forEach { it ->
                    if (startX + it < row && map[startX + it][startY] == -1) return false
                }
            }
            "W" -> {
                (1..moveCount).forEach { it ->
                    if (startY - it >= 0 && map[startX][startY - it] == -1) return false
                }
            }
            "E" -> {
                (1..moveCount).forEach { it ->
                    if (startY + it < col && map[startX][startY + it] == -1) return false
                }
            }
        }

        return true
    }

    private fun checkOutSide(routes: String, moveCount: Int): Boolean {
        when (routes) {
            "N" -> if (startX - moveCount < 0) return false
            "S" -> if (startX + moveCount >= row) return false
            "W" -> if (startY - moveCount < 0) return false
            "E" -> if (startY + moveCount >= col) return false
        }

        return true
    }
}