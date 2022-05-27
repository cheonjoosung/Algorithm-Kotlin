package backjun.g5

import java.lang.StringBuilder
import java.util.*

class P2023 {

    val sb = StringBuilder()
    fun main() {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()

        dfs(0, "", n)
        println(sb.toString())
        sc.close()
    }

    fun dfs(idx: Int, num: String, n: Int) {
        if (idx == n) {
            sb.append(num).append("\n")
            return
        }

        for (i in 1..9) {
            if (isPrime(Integer.valueOf(num + i)))
                dfs(idx + 1, num + i, n)
        }
    }

    //에라토스테네스의 소수 판별 방식 사용.
    fun isPrime(num: Int): Boolean {
        if (num == 1) return false

        val sqrt = Math.sqrt(num.toDouble()).toInt()
        for (i in 2..sqrt) {
            if (num % i == 0) return false
        }

        return true
    }

}