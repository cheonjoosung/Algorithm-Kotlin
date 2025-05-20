package backjun.s2

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val s = readln().split(" ").map { it.toInt() }

    /**
     * 슬라이딩 윈도우로 현재 구간의 홀수 개수를 추적
     * 유효한 구간 내의 짝수만으로 구성된 수열 길이를 계산
     * 홀수를 삭제한 뒤 남은 짝수 연속 부분 수열이므로 (end - start + 1) - 홀수 개수로 계산
     */

    var maxLength = 0
    var left = 0
    var oddCount = 0

    for (right in s.indices) {
        if (s[right] % 2 != 0) oddCount++

        while (oddCount > k) {
            if (s[left] % 2 != 0) oddCount--
            left++
        }

        // 현재 윈도우에서 짝수만으로 이루어진 수열 길이 = (right - left + 1) - 홀수 개수
        maxLength = maxOf(maxLength, right - left + 1 - oddCount)
    }

    println(maxLength)
}