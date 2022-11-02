package pg.lv0

fun main() {
    PolynomialSum().solution("3x + 7 + x").also { println(it) }//	"4x + 7"
    PolynomialSum().solution("x + x + x").also { println(it) } //	"3x"
}

class PolynomialSum {

    fun solution(polynomial: String): String {

        val token = polynomial.split(" ")

        var xCount = 0
        var nCount = 0

        for (str in token) {
            if (str == "+") continue

            if (str.contains("x"))
                xCount += if (str == "x") 1
                else str.replace("x", "").toInt()

            else nCount += str.toInt()
        }

        val sb = StringBuilder()

        if (xCount != 0) {
            if (xCount == 1) sb.append("x")
            else sb.append(xCount).append("x")
        }

        if (nCount != 0) {
            if (xCount != 0) sb.append(" + ").append(nCount)
            else sb.append(nCount)
        }

        return sb.toString()
    }
}