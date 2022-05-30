fun main() {

    val br = System.`in`.bufferedReader()


    val n = br.readLine().toInt()
    val splitArr = br.readLine().split(" ")

    val arr = IntArray(n + 1) { 0 }
    val dp = IntArray(n + 1) { 0 }

    for (i in 1..n) arr[i] = splitArr[i-1].toInt()

    dp[1] = arr[1]

    for (i in 2..n) {
        dp[i] = arr[i]

        for (j in 1 until i) {
            if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + arr[i])
        }
    }

    var max = Int.MIN_VALUE
    for (i in 1..n) {
        if (dp[i] > max) {
            max = dp[i]
        }
    }

    println(max)
}