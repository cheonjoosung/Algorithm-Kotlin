package pg.lv2

fun main() {
    LineLength().solution(
        arrayOf(
            //intArrayOf(0, 1), intArrayOf(2, 5), intArrayOf(3, 9),
            intArrayOf(-1, -1), intArrayOf(1, 3), intArrayOf(3, 9),
            //intArrayOf(0, 5), intArrayOf(3, 9), intArrayOf(1, 10)
        )
    )
}

class LineLength {

    fun solution(lines: Array<IntArray>): Int {

        val minNumber = lines.map { it[0] }.minOrNull() ?: 0
        val maxNumber = lines.map { it[1] }.maxOrNull() ?: 0

        val size = if (minNumber < 0) maxNumber - minNumber + 1 else maxNumber + 1
        val add = if (minNumber < 0) Math.abs(minNumber) else 0
        val arr = IntArray(size) { 0 }

        for (line in lines) {
            for (j in line[0]+add until line[1]+add) {
                arr[j] += 1
            }
        }

        println(add)
        arr.forEach { print("$it ") }

        return arr.count { it >= 2 }
    }
}