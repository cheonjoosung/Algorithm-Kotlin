package pg.lv3

fun solution(n: Int, results: Array<IntArray>): Int {
    val win = Array(n + 1) { BooleanArray(n + 1) } // win[a][b] = a가 b를 이김

    /*
    n x n 크기의 2차원 배열을 만들어 graph[a][b] = true라면 a가 b를 이겼음을 의미.
    모든 경기 결과를 입력한 후, 플로이드–워셜 알고리즘으로 간접 승패 관계를 채워줌.
    이후 각 선수별로 자신이 이기거나 진 것이 확실한 선수 수가 (n - 1) 인지 확인.
     */

    // 직접 경기 결과 기록
    for ((a, b) in results) {
        win[a][b] = true
    }

    // 간접 경기 결과 추론 (Floyd-Warshall 응용)
    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (win[i][k] && win[k][j]) {
                    win[i][j] = true
                }
            }
        }
    }

    var answer = 0

    for (i in 1..n) {
        var count = 0
        for (j in 1..n) {
            if (i == j) continue
            if (win[i][j] || win[j][i]) {
                count++
            }
        }
        if (count == n - 1) {
            answer++
        }
    }

    return answer
}