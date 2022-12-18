package pg.lv2

fun main() {
    NumberCardDivide().solution(intArrayOf(10, 17), intArrayOf(5, 20)).also { println(it) }
    NumberCardDivide().solution(intArrayOf(10, 20), intArrayOf(5, 17)).also { println(it) }
    NumberCardDivide().solution(intArrayOf(14, 35, 119), intArrayOf(18, 30, 102)).also { println(it) }
}

class NumberCardDivide {

    fun solution(arrayA: IntArray, arrayB: IntArray): Int {

        val sortedA = arrayA.sorted()
        val gcdA = gcdLoop(sortedA)
        val aFlag = canDivide(arrayB, gcdA)

        val sortedB = arrayB.sorted()
        val gcdB = gcdLoop(sortedB)
        val bFlag = canDivide(arrayA, gcdB)

        return when {
            aFlag && bFlag -> 0
            else -> gcdA.coerceAtLeast(gcdB)
        }
    }

    private fun canDivide(array: IntArray, gcd: Int): Boolean {
        var aFlag = false

        for (b in array) {
            if (b % gcd == 0) {
                aFlag = true
                break
            }
        }
        return aFlag
    }

    private fun gcdLoop(list: List<Int>): Int {
        return list.reduce { a, b -> getGCD(a, b) }
    }

    private fun getGCD(_a: Int, _b: Int): Int {
        var a = _a.coerceAtLeast(_b)
        var b = _a.coerceAtMost(_b)

        while (b > 0) {
            val tmp = a
            a = b
            b = tmp % b
        }

        return a
    }
}