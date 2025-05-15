package backjun.b

fun main() {

    val t = readln().toInt() // 테스트 케이스 수

    repeat(t) {
        val k = readln().toInt()
        val n = readln().toInt()

        val apt = Array(k + 1) { IntArray(n + 1) }

        // 0층 초기화
        for (i in 1..n) {
            apt[0][i] = i
        }

        // 1층 이상 채우기
        for (i in 1..k) {
            for (j in 1..n) {
                apt[i][j] = apt[i][j - 1] + apt[i - 1][j]
            }
        }

        println(apt[k][n])
    }
}