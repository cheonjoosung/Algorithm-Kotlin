package pg.lv3

class LongestPalindrome {
    fun solution(s: String): Int {
        val T = preprocessString(s)
        val P = IntArray(T.size)
        var center = 0
        var right = 0
        var maxLen = 0
        for (i in 1 until T.size - 1) {
            val iMirror = 2 * center - i
            if (right > i) {
                P[i] = minOf(right - i, P[iMirror])
            }
            while (T[i + (1 + P[i])] == T[i - (1 + P[i])]) {
                P[i]++
            }
            if (i + P[i] > right) {
                center = i
                right = i + P[i]
            }
            maxLen = maxOf(maxLen, P[i])
        }
        return maxLen
    }

    private fun preprocessString(s: String): CharArray {
        val n = s.length
        val T = CharArray(n * 2 + 3)
        T[0] = '^'
        T[n * 2 + 2] = '$'
        for (i in 1..n) {
            T[2 * i - 1] = '#'
            T[2 * i] = s[i - 1]
        }
        T[n * 2 + 1] = '#'
        return T
    }
}

fun main() {
    LongestPalindrome().solution("abcdcba").also { println(it) } //7
    LongestPalindrome().solution("abacde").also { println(it) } //3
}