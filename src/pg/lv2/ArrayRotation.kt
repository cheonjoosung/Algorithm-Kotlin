package pg.lv2

class ArrayRotation {

    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()

        var temp = Array(rows) { j ->
            IntArray(columns) { i -> i + columns * (j) + 1 }
        }

        for (arr in queries) {

            val x1 = arr[0] - 1
            val y1 = arr[1] - 1
            val x2 = arr[2] - 1
            val y2 = arr[3] - 1

            val min = move(x1, y1, x2, y2, arr, temp)
            answer.add(min)
        }


        return answer.toIntArray()
    }

    private fun move(x1: Int, y1: Int, x2: Int, y2: Int, arr: IntArray, temp: Array<IntArray>): Int {
        //우 상 좌 하
        val dx = intArrayOf(0, 1, 0, -1)
        val dy = intArrayOf(1, 0, -1, 0)

        var d = 0
        var nx = x1
        var ny = y1

        var before = temp[x1][y1]
        var save = before
        var min = Math.min(Int.MAX_VALUE, temp[x1][y1])

        while (true) {

            if (nx == x1 && ny == y2) d = 1
            if (nx == x2 && ny == y2) d = 2
            if (nx == x2 && ny == y1) d = 3

            min = Math.min(min, temp[nx][ny])

            save = temp[nx][ny]
            temp[nx][ny] = before
            before = save

            nx += dx[d]
            ny += dy[d]

            if (nx == x1 && ny == y1) {
                temp[nx][ny] = before
                break;
            }
        }

//        println(min)
        return min
    }
}