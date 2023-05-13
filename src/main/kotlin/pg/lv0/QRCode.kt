package pg.lv0

fun main() {
    QRCode().solution(3, 1, "qjnwezgrpirldywt").also { println(it) }
    QRCode().solution(1, 0, "programmers").also { println(it) }
}

class QRCode {

    fun solution(q: Int, r: Int, code: String): String {

        return code.mapIndexed { index, c ->
            if (index % q == r) c else ""
        }.joinToString("")
    }
}