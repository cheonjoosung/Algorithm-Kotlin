package backjun.s2

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()

    /*
    이 공식의 조건은 다음과 같습니다:
    M: 총 과일 개수
    N: 과일 종류 (각 종류에 1개 이상 분배)
    (M - 1)개의 별 사이에서 (N - 1)개의 칸막이를 고르는 조합
     */
    if (m < n) {
        println(0)
    } else {
        val result = combination(m - 1, n - 1)
        println(result)
    }
}

fun combination(n: Int, r: Int): Long {
    if (r == 0 || r == n) return 1
    if (r == 1) return n.toLong()
    var res = 1L
    for (i in 1..r) {
        res = res * (n - i + 1) / i
    }
    return res
}