package backjun.g5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {


    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val arr = IntArray(N + 1)
    val dp = Array(N + 1) { IntArray(2) }

    val st = StringTokenizer(br.readLine())
    for (i in 1..N)
        arr[i] = st.nextToken().toInt()

    var ans = arr[1]
    dp[1][0] = arr[1]
    dp[1][1] = arr[1]

    for (i in 2..N) {
        dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i])
        dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0])
        ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]))
    }
    println(ans)
}