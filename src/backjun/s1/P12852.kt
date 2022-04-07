package backjun.s1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class P12852 {

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val N = br.readLine().toInt()
        val dp = Array(N + 1) { 0 }
        val pre = Array(N + 1) { 0 }

        dp[1] = 0 // 어차피 1이니까 1로 만들기위해 연산할 필요 x

        for (i in 2..N) {
            dp[i] = dp.get(i - 1) + 1
            pre[i] = i - 1
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                Math.min(dp.get(i), dp[i / 2] + 1).also { dp[i] = it }
                pre[i] = i / 2
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1)
                pre[i] = i / 3
            }
        }

        bw.write(dp[N].toString() + "\n")
        var cur = N

        while (true) {
            bw.write("$cur ")
            if (cur == 1) break
            cur = pre.get(cur)
        }

        bw.flush()
        bw.close()

    }
}
