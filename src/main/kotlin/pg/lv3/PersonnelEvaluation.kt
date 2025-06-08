package pg.lv3

fun solution(scores: Array<IntArray>): Int {
    val wanho = scores[0]
    val wanhoSum = wanho[0] + wanho[1]

    // 1. 모든 사원들을 근무태도 내림차순, 동료평가 오름차순으로 정렬
    val sorted = scores.sortedWith(compareByDescending<IntArray> { it[0] }.thenBy { it[1] })

    var maxPeer = 0
    val validList = mutableListOf<Int>()

    for (score in sorted) {
        val att = score[0]
        val peer = score[1]

        // 완호보다 두 점수 모두 높은 사원이 있다면 인센티브 불가
        if (att > wanho[0] && peer > wanho[1]) return -1

        // 인센티브 받을 수 있는 사람은 이전까지의 최대 peer보다 클 때만 인정
        if (peer >= maxPeer) {
            maxPeer = maxOf(maxPeer, peer)
            validList.add(score[0] + score[1])  // 점수 합 저장
        }
    }

    // 2. 유효한 사원들 중에서 완호보다 점수합 높은 사람 수 세기
    val sortedSums = validList.sortedDescending()
    var rank = 1
    var i = 0

    while (i < sortedSums.size) {
        val curScore = sortedSums[i]
        val count = sortedSums.count { it == curScore }

        if (curScore == wanhoSum) return rank
        if (curScore < wanhoSum) break

        rank += count
        i += count
    }

    return rank
}
