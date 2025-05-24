package backjun.s2

fun main() {
    val n = readln().toInt()

    // 1. 피보나치 수열로 (people, chickens) 쌍 구하기
    val sets = mutableListOf<Pair<Int, Int>>()
    var a = 1
    var b = 1
    while (true) {
        val people = a + b
        val chickens = b
        if (people > n) break
        sets.add(Pair(people, chickens))
        val temp = a + b
        a = b
        b = temp
    }

    // 2. DP: dp[i] = i명을 만족하는 치킨 수 집합
    val dp = Array(n + 1) { mutableSetOf<Int>() }
    dp[0].add(0) // 초기화

    for (i in 1..n) {
        for ((people, chickens) in sets) {
            if (i >= people) {
                for (prev in dp[i - people]) {
                    dp[i].add(prev + chickens)
                }
            }
        }
    }

    if (dp[n].isEmpty()) {
        println("-1 -1") // 불가능한 경우
    } else {
        println("${dp[n].minOrNull()} ${dp[n].maxOrNull()}")
    }
}