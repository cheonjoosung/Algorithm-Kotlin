package pg.lv2

fun main() {
    println(solution(4))
}

var answer = 0

fun solution(n: Int): Int {

    answer = 0
    for (i in 1..n) {
        val arr = IntArray(n + 1) { 0 }
        arr[1] = i
        dfs(arr, 1, n)
    }
    return answer
}

private fun dfs(arr: IntArray, row: Int, n: Int) {
    if (row == n) answer++
    else {
        for (col in 1..n) {
            arr[row + 1] = col
            if (check(arr, row + 1)) {
                dfs(arr, row + 1, n)
            }
        }
    }
}

fun check(arr: IntArray, row: Int): Boolean {
    for (i in 1 until row) {
        // 같은 라인 체크
        if (arr[i] == arr[row]) return false

        // 대각선 체크 (절대값 비교)
        if (Math.abs(i - row) == Math.abs(arr[i] - arr[row])) return false
    }

    return true
}